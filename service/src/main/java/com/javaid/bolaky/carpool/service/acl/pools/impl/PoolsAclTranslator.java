package com.javaid.bolaky.carpool.service.acl.pools.impl;

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

			pool.setPoolType(PoolType.convertCode(carPoolRegistrationVO
					.getPoolCode()));
			pool.setValidLicense(carPoolRegistrationVO.getValidLicense());
			pool.setSmoker(carPoolRegistrationVO.getSmoker());
			pool.setOneWayTravel(carPoolRegistrationVO.getOneWayTravel());
			pool.setNumberOfCurrentPassengers(carPoolRegistrationVO
					.getNumberOfCurrentPassengers());
			pool.setPrefferedGenderToTravelWith(Gender
					.convertCode(carPoolRegistrationVO.getGenderToTravelWith()));
			pool.setUserPoolAdditionalDetails(carPoolRegistrationVO
					.getAdditionalDetails());

			if (carPoolRegistrationVO.getTravelOnMonday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.MONDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnMonday());
			}
			if (carPoolRegistrationVO.getTravelOnTuesday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.TUESDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnTuesday());
			}
			if (carPoolRegistrationVO.getTravelOnWednesday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnWednesday());
			}
			if (carPoolRegistrationVO.getTravelOnThursday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.THURSDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnThursday());
			}
			if (carPoolRegistrationVO.getTravelOnFriday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnFriday());
			}
			if (carPoolRegistrationVO.getTravelOnSaturday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.SATURDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSaturday());
			}
			if (carPoolRegistrationVO.getTravelOnSunday()) {
				pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY,
						carPoolRegistrationVO
								.getNumberOfAvailableSeatsOnSunday());
			}

			pool.getVehicleInfo().setOwner(carPoolRegistrationVO.getCarOwner());
			pool.getVehicleInfo().setMaxNumberOfSeats(
					carPoolRegistrationVO.getMaxNumberOfSeats());
			pool.getVehicleInfo().setMakeCode(
					carPoolRegistrationVO.getVehicleMake());
			pool.getVehicleInfo().setModelCode(
					carPoolRegistrationVO.getVehicleModel());
			pool.getVehicleInfo().setTypeCode(
					carPoolRegistrationVO.getVehicleType());

			pool.getStartingPointInfo().setStartingDate(
					carPoolRegistrationVO.getStartingCarpoolDate());
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

				carPoolErrors.add(CarPoolError.convertFrom(poolsError));
			}
		}

		return carPoolErrors;
	}

}
