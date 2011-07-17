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

			if (carPoolRegistrationVO.getTravelOnMonday() != null
					&& carPoolRegistrationVO.getTravelOnMonday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.MONDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnMonday());
			}
			if (carPoolRegistrationVO.getTravelOnTuesday() != null
					&& carPoolRegistrationVO.getTravelOnTuesday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.TUESDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnTuesday());
			}
			if (carPoolRegistrationVO.getTravelOnWednesday() != null
					&& carPoolRegistrationVO.getTravelOnWednesday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnWednesday());
			}
			if (carPoolRegistrationVO.getTravelOnThursday() != null
					&& carPoolRegistrationVO.getTravelOnThursday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.THURSDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnThursday());
			}
			if (carPoolRegistrationVO.getTravelOnFriday() != null
					&& carPoolRegistrationVO.getTravelOnFriday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnFriday());
			}
			if (carPoolRegistrationVO.getTravelOnSaturday() != null
					&& carPoolRegistrationVO.getTravelOnSaturday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.SATURDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSaturday());
			}
			if (carPoolRegistrationVO.getTravelOnSunday() != null
					&& carPoolRegistrationVO.getTravelOnSunday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSunday());
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
