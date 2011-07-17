package com.javaid.bolaky.carpool.service.acl.pools.impl;

import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToBoolean;
import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToCharacter;
import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToInteger;
import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToLocalDate;
import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToLocalTime;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolType;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;

public class PoolsAclTranslator {

	public static Pool convertPool(PoolRegistrationVO carPoolRegistrationVO) {

		Pool pool = null;

		if (carPoolRegistrationVO != null) {

			pool = new Pool();

			pool.setUsername(carPoolRegistrationVO.getUsername());

			pool.setPoolName(carPoolRegistrationVO.getPoolName());
			pool.setShareCost(convertToBoolean(carPoolRegistrationVO
					.getShareCost()));
			pool.setPoolType(PoolType
					.convertCode(convertToInteger(carPoolRegistrationVO
							.getPoolCode())));
			pool.setValidLicense(convertToBoolean(carPoolRegistrationVO
					.getValidLicense()));
			pool.setSmoker(convertToBoolean(carPoolRegistrationVO.getSmoker()));
			pool.setOneWayTravel(convertToBoolean(carPoolRegistrationVO
					.getOneWayTravel()));

			Integer numberOfCurrentPassengers = convertToInteger(carPoolRegistrationVO
					.getNumberOfCurrentPassengers());

			pool.setNumberOfCurrentPassengers(numberOfCurrentPassengers != null ? numberOfCurrentPassengers
					: 0);
			pool.setPrefferedGenderToTravelWith(Gender
					.convertCode(convertToCharacter(carPoolRegistrationVO
							.getGenderToTravelWith())));
			pool.setUserPoolAdditionalDetails(carPoolRegistrationVO
					.getAdditionalDetails());

			Boolean travelOnMonday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnMonday());
			if (travelOnMonday != null && travelOnMonday) {
				pool.addAvailableSeatsForADay(DayOfWeek.MONDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnMonday()));
			}

			Boolean travelOnTuesday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnTuesday());
			if (travelOnTuesday != null && travelOnTuesday) {
				pool.addAvailableSeatsForADay(DayOfWeek.TUESDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnTuesday()));
			}

			Boolean travelOnWednesday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnWednesday());
			if (travelOnWednesday != null && travelOnWednesday) {
				pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnWednesday()));
			}

			Boolean travelOnThursday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnThursday());
			if (travelOnThursday != null && travelOnThursday) {
				pool.addAvailableSeatsForADay(DayOfWeek.THURSDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnThursday()));
			}

			Boolean travelOnFriday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnFriday());
			if (travelOnFriday != null && travelOnFriday) {
				pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnFriday()));
			}

			Boolean travelOnSaturday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnSaturday());
			if (travelOnSaturday != null && travelOnSaturday) {
				pool.addAvailableSeatsForADay(DayOfWeek.SATURDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSaturday()));
			}

			Boolean travelOnSunday = convertToBoolean(carPoolRegistrationVO
					.getTravelOnSunday());
			if (travelOnSunday != null && travelOnSunday) {
				pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY,
						convertToInteger(carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSunday()));
			}

			pool.getVehicleInfo().setOwner(
					convertToBoolean(carPoolRegistrationVO.getCarOwner()));
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
					convertToLocalDate(carPoolRegistrationVO
							.getStartingPoolDate()));
			pool.getStartingPointInfo()
					.setDepartureTime(
							convertToLocalTime(carPoolRegistrationVO
									.getDepartureTime()));
			pool.getStartingPointInfo().setFromAreaCode(
					carPoolRegistrationVO.getFromAreaCode());
			pool.getStartingPointInfo().setFromDistrictCode(
					carPoolRegistrationVO.getFromDistrictCode());

			pool.getDestinationInfo()
					.setEndDate(
							convertToLocalDate(carPoolRegistrationVO
									.getEndOfPoolDate()));
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

}
