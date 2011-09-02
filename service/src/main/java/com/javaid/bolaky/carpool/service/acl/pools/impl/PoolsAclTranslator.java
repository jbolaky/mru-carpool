package com.javaid.bolaky.carpool.service.acl.pools.impl;

import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToCharacter;
import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToInteger;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.ContactDriverVO;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.pools.entity.Passenger;
import com.javaid.bolaky.domain.pools.entity.PassengerRequestInfo;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolType;
import com.javaid.bolaky.domain.pools.entity.enumerated.StateStatus;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

public class PoolsAclTranslator {

	public static Pool convertPool(PoolRegistrationVO carPoolRegistrationVO, Pool pool) {

		if (carPoolRegistrationVO != null) {

			pool.setUsername(carPoolRegistrationVO.getUsername());
			pool.setGender(Gender.convertCode(carPoolRegistrationVO.getGender()
					.charAt(0)));
			pool.setPoolName(carPoolRegistrationVO.getPoolName());
			pool.setShareCost(carPoolRegistrationVO.getShareCost());
			pool.setPoolType(PoolType
					.convertCode(convertToInteger(carPoolRegistrationVO
							.getPoolType() != null ? carPoolRegistrationVO
							.getPoolType().getCode() : null)));
			pool.setValidLicense(carPoolRegistrationVO.getValidLicense());
			pool.setSmoker(carPoolRegistrationVO.getSmoker());
			pool.setOneWayTravel(carPoolRegistrationVO.getOneWayTravel());

			Integer numberOfCurrentPassengers = convertToInteger(carPoolRegistrationVO
					.getNumberOfCurrentPassengers());

			pool.setNumberOfCurrentPassengers(numberOfCurrentPassengers != null ? numberOfCurrentPassengers
					: 0);
			pool.setPrefferedGenderToTravelWith(Gender
					.convertCode(convertToCharacter(carPoolRegistrationVO
							.getGenderToTravelWith())));
			pool.setUserPoolAdditionalDetails(carPoolRegistrationVO
					.getAdditionalDetails());

			Boolean travelOnMonday = carPoolRegistrationVO.getTravelOnMonday();
			if (travelOnMonday != null && travelOnMonday) {
				pool.addAvailableSeatsForADay(DayOfWeek.MONDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnMonday()));
			}

			Boolean travelOnTuesday = carPoolRegistrationVO
					.getTravelOnTuesday();
			if (travelOnTuesday != null && travelOnTuesday) {
				pool.addAvailableSeatsForADay(DayOfWeek.TUESDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnTuesday()));
			}

			Boolean travelOnWednesday = carPoolRegistrationVO
					.getTravelOnWednesday();
			if (travelOnWednesday != null && travelOnWednesday) {
				pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnWednesday()));
			}

			Boolean travelOnThursday = carPoolRegistrationVO
					.getTravelOnThursday();
			if (travelOnThursday != null && travelOnThursday) {
				pool.addAvailableSeatsForADay(DayOfWeek.THURSDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnThursday()));
			}

			Boolean travelOnFriday = carPoolRegistrationVO.getTravelOnFriday();
			if (travelOnFriday != null && travelOnFriday) {
				pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnFriday()));
			}

			Boolean travelOnSaturday = carPoolRegistrationVO
					.getTravelOnSaturday();
			if (travelOnSaturday != null && travelOnSaturday) {
				pool.addAvailableSeatsForADay(DayOfWeek.SATURDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSaturday()));
			}

			Boolean travelOnSunday = carPoolRegistrationVO.getTravelOnSunday();
			if (travelOnSunday != null && travelOnSunday) {
				pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSunday()));
			}

			pool.getVehicleInfo().setOwner(carPoolRegistrationVO.getCarOwner());
			pool.getVehicleInfo().setMaxNumberOfSeats(
					convertToInteger(carPoolRegistrationVO
							.getMaxNumberOfSeats()));
			pool.getVehicleInfo().setMakeCode(
					carPoolRegistrationVO.getVehicleMake());
			pool.getVehicleInfo().setModelCode(
					carPoolRegistrationVO.getVehicleModel());
			pool.getVehicleInfo().setTypeCode(
					carPoolRegistrationVO.getVehicleType());

			pool.getStartingPointInfo().setStartingDate(
					carPoolRegistrationVO.getStartingPoolDate());
			pool.getStartingPointInfo().setDepartureTime(
					carPoolRegistrationVO.getDepartureTime());
			pool.getStartingPointInfo().setFromAreaCode(
					carPoolRegistrationVO.getFromAreaCode());
			pool.getStartingPointInfo().setFromDistrictCode(
					carPoolRegistrationVO.getFromDistrictCode());

			pool.getDestinationInfo().setEndDate(
					carPoolRegistrationVO.getEndOfPoolDate());
			pool.getDestinationInfo().setToAreaCode(
					carPoolRegistrationVO.getToAreaCode());
			pool.getDestinationInfo().setToDistictCode(
					carPoolRegistrationVO.getToDistrictCode());
		}

		return pool;
	}

	public static Set<CarPoolError> convertToCarPoolErrors(
			Set<PoolsError> poolsErrors) {

		Set<CarPoolError> carPoolErrors = null;

		if (poolsErrors != null && !poolsErrors.isEmpty()) {

			carPoolErrors = new ListOrderedSet<CarPoolError>();

			for (PoolsError poolsError : poolsErrors) {

				CarPoolError carPoolError = CarPoolError
						.convertFrom(poolsError);

				if (carPoolError != null) {
					carPoolErrors.add(carPoolError);
				}
			}
		}

		return carPoolErrors;
	}

	public static PoolSearchCriteria convert(PoolSearchVO poolSearchVO) {

		PoolSearchCriteria poolSearchCriteria = null;

		if (poolSearchVO != null) {

			poolSearchCriteria = new PoolSearchCriteria();

			poolSearchCriteria.setDriverAgeGroup(AgeGroup
					.convertCode(poolSearchVO.getAgeGroup()));
			poolSearchCriteria.setDriverGender(Gender.convertCode(poolSearchVO
					.getDriverGender()));
			poolSearchCriteria
					.setNumberOfCurrentPassengers(convertToInteger(poolSearchVO
							.getNumberOfPassengers()));
			poolSearchCriteria.setOneWayReturn(poolSearchVO.getOneWayTravel());
			poolSearchCriteria.setShareCost(poolSearchVO.getShareCost());

		}

		return poolSearchCriteria;
	}

	public static PoolSearchCriteria convertToPoolSearchCriteria(
			String poolCreatorUsername) {

		PoolSearchCriteria poolSearchCriteria = null;

		if (poolCreatorUsername != null) {

			poolSearchCriteria = new PoolSearchCriteria();
			poolSearchCriteria.setUsername(poolCreatorUsername);
		}

		return poolSearchCriteria;
	}

	public static Set<PoolSearchResultVO> convert(List<Pool> pools) {

		Set<PoolSearchResultVO> poolSearchResultVOs = new ListOrderedSet<PoolSearchResultVO>();

		if (pools != null && !pools.isEmpty()) {

			for (Pool pool : pools) {

				poolSearchResultVOs.add(PoolsAclTranslator.convert(pool));
			}
		}

		return poolSearchResultVOs;
	}

	public static PoolSearchResultVO convert(Pool pool) {

		PoolSearchResultVO poolSearchResultVO = null;

		if (pool != null) {

			poolSearchResultVO = new PoolSearchResultVO();

			poolSearchResultVO.setPoolId(pool.getPoolId());
			poolSearchResultVO.setDepartureTime(pool.getStartingPointInfo()
					.getDepartureTime());
			poolSearchResultVO.setDriverAdditionalDetails(pool
					.getUserPoolAdditionalDetails());
			poolSearchResultVO.setFromAreaName(pool.getDestinationInfo()
					.getToAreaCode());
		}

		return poolSearchResultVO;
	}

	public static PoolRegistrationVO convertToPoolRegistrationVO(Pool pool) {

		PoolRegistrationVO poolRegistrationVO = null;

		if (pool != null) {

			poolRegistrationVO = new PoolRegistrationVO();

			poolRegistrationVO.setPoolId(pool.getPoolId());
			poolRegistrationVO.setAdditionalDetails(pool
					.getUserPoolAdditionalDetails());
			poolRegistrationVO.setCarOwner(pool.getVehicleInfo().isOwner());
			poolRegistrationVO.setDepartureTime(pool.getStartingPointInfo()
					.getDepartureTime());
			poolRegistrationVO.setEndOfPoolDate(pool.getDestinationInfo()
					.getEndDate());
			poolRegistrationVO.setFromAreaCode(pool.getStartingPointInfo()
					.getFromAreaCode());
			poolRegistrationVO.setFromDistrictCode(pool.getStartingPointInfo()
					.getFromDistrictCode());
			poolRegistrationVO.setGender(pool.getGender().getCode().toString());
			poolRegistrationVO.setGenderToTravelWith(pool
					.getPrefferedGenderToTravelWith().getCode().toString());
			poolRegistrationVO.setMaxNumberOfSeats(pool.getVehicleInfo()
					.getMaxNumberOfSeats().toString());
			poolRegistrationVO.setNumberOfCurrentPassengers(pool
					.getNumberOfCurrentPassengers().toString());
			poolRegistrationVO.setOneWayTravel(pool.getOneWayTravel());
			poolRegistrationVO.setPoolName(pool.getPoolName());
			poolRegistrationVO
					.setPoolType(com.javaid.bolaky.carpool.service.vo.PoolType
							.convertCode(pool.getPoolType().getCode()
									.toString()));
			poolRegistrationVO.setShareCost(pool.getShareCost());
			poolRegistrationVO.setSmoker(pool.getSmoker());
			poolRegistrationVO.setStartingPoolDate(pool.getStartingPointInfo()
					.getStartingDate());
			poolRegistrationVO.setToAreaCode(pool.getDestinationInfo()
					.getToAreaCode());
			poolRegistrationVO.setToDistrictCode(pool.getDestinationInfo()
					.getToDistictCode());
			poolRegistrationVO.setUsername(pool.getUsername());
			poolRegistrationVO.setValidLicense(pool.getValidLicense());
			poolRegistrationVO.setVehicleMake(pool.getVehicleInfo()
					.getMakeCode());
			poolRegistrationVO.setVehicleModel(pool.getVehicleInfo()
					.getModelCode());
			poolRegistrationVO.setVehicleType(pool.getVehicleInfo()
					.getTypeCode());

			for (DayOfWeek dayOfWeek : DayOfWeek.values()) {

				if (pool.getAvailableSeatsForADay(dayOfWeek) != null
						&& pool.getAvailableSeatsForADay(dayOfWeek) != 0) {

					switch (dayOfWeek) {
					case MONDAY:
						poolRegistrationVO.setTravelOnMonday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnMonday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case TUESDAY:
						poolRegistrationVO.setTravelOnTuesday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnTuesday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case WEDNESDAY:
						poolRegistrationVO.setTravelOnWednesday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnWednesday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case THURSDAY:
						poolRegistrationVO.setTravelOnThursday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnThursday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case FRIDAY:
						poolRegistrationVO.setTravelOnFriday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnFriday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case SATURDAY:
						poolRegistrationVO.setTravelOnSaturday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnSaturday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;
					case SUNDAY:
						poolRegistrationVO.setTravelOnSunday(true);
						poolRegistrationVO
								.setNumberOfAvailableSeatsOnSunday(pool
										.getAvailableSeatsForADay(dayOfWeek)
										.toString());
						break;

					default:
						break;
					}
				}
			}
		}

		return poolRegistrationVO;
	}

	public static Set<PoolVO> convertToPoolVOs(List<Pool> pools) {

		Set<PoolVO> poolVOs = new ListOrderedSet<PoolVO>();

		if (pools != null && !pools.isEmpty()) {

			for (Pool pool : pools) {

				poolVOs.add(convertToPoolVO(pool));
			}
		}

		return poolVOs;
	}

	public static PoolVO convertToPoolVO(Pool pool) {

		PoolVO poolVO = null;

		if (pool != null) {

			poolVO = new PoolVO();

			poolVO.setPoolId(pool.getPoolId());
			poolVO.setCompleted(pool.isCompleted());
			poolVO.setPoolName(pool.getPoolName());
			poolVO.setNumberOfNewPoolRequest(getNumberOfNewRequest(pool
					.getPassengers()));
			// poolVO.setArrivalTime(pool.getDestinationInfo().)
			poolVO.setDepartureTime(pool.getStartingPointInfo() != null ? pool
					.getStartingPointInfo().getDepartureTime() : null);
			poolVO.setDriverGender(pool.getGender() != null ? pool.getGender()
					.getCode() : null);
			poolVO.setEndDate(pool.getDestinationInfo() != null ? pool
					.getDestinationInfo().getEndDate() : null);
			poolVO.setNumberOfPassengers(pool.getNumberOfCurrentPassengers());
			poolVO.setOneWayReturn(pool.getOneWayTravel());
			poolVO.setPoolType(pool.getPoolType() != null ? com.javaid.bolaky.carpool.service.vo.PoolType
					.convertCode(pool.getPoolType().getCode().toString())
					: null);
			poolVO.setPrefferedGenderToTravelWith(pool
					.getPrefferedGenderToTravelWith() != null ? pool
					.getPrefferedGenderToTravelWith().getCode() : null);
			poolVO.setShareCost(poolVO.getShareCost());
			poolVO.setDepartureTime(pool.getStartingPointInfo()
					.getDepartureTime());
			poolVO.setAddtionalDetails(pool.getUserPoolAdditionalDetails());
			poolVO.setFromAreaName(pool.getDestinationInfo().getToAreaCode());
		}

		return poolVO;
	}

	public static Passenger convert(ContactDriverVO contactDriverVO) {

		Passenger passenger = null;

		if (contactDriverVO != null) {

			passenger = new Passenger();

			passenger.setUsername(contactDriverVO.getUsername());

			PassengerRequestInfo passengerRequestInfo = new PassengerRequestInfo();
			passengerRequestInfo.setEmailAddress(contactDriverVO
					.getEmailAddress());
			passengerRequestInfo.setEnquiryDetails(contactDriverVO
					.getEnquiryDetails());
			passengerRequestInfo.setPhoneNumber(contactDriverVO
					.getPhoneNumber());

			passenger.addPassengerRequestInfo(passengerRequestInfo);
		}

		return passenger;
	}

	private static Integer getNumberOfNewRequest(Set<Passenger> passengers) {

		Integer numberOfNewRequest = null;

		if (passengers != null && !passengers.isEmpty()) {

			for (Passenger passenger : passengers) {

				if (StateStatus.PENDING.equals(passenger.getStateStatus())) {

					if (numberOfNewRequest == null) {
						numberOfNewRequest = 0;
					}

					numberOfNewRequest++;
				}
			}
		}

		return numberOfNewRequest;
	}
}
