package com.javaid.bolaky.carpool.service.hibernate.validator;

import static com.javaid.bolaky.carpool.service.util.PoolUtils.convertToInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.TravelDays;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;

public class TravelDaysValidator implements
		ConstraintValidator<TravelDays, PoolRegistrationVO> {

	public void initialize(TravelDays travelDays) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(PoolRegistrationVO carPoolRegistrationVO,
			ConstraintValidatorContext context) {

		boolean isValid = true;

		Boolean travelOnMonday = carPoolRegistrationVO.getTravelOnMonday();
		Integer numberOfAvailableSeatsOnMonday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnMonday());
		Boolean travelOnTuesday = carPoolRegistrationVO.getTravelOnThursday();
		Integer numberOfAvailableSeatsOnTuesday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnTuesday());
		Boolean travelOnWednesday = carPoolRegistrationVO
				.getTravelOnWednesday();
		Integer numberOfAvailableSeatsOnWednesday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnWednesday());
		Boolean travelOnThursday = carPoolRegistrationVO.getTravelOnThursday();
		Integer numberOfAvailableSeatsOnThursday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnThursday());
		Boolean travelOnFriday = carPoolRegistrationVO.getTravelOnFriday();
		Integer numberOfAvailableSeatsOnFriday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnFriday());
		Boolean travelOnSaturday = carPoolRegistrationVO.getTravelOnSaturday();
		Integer numberOfAvailableSeatsOnSaturday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnSaturday());
		Boolean travelOnSunday = carPoolRegistrationVO.getTravelOnSunday();
		Integer numberOfAvailableSeatsOnSunday = convertToInteger(carPoolRegistrationVO
				.getNumberOfAvailableSeatsOnSunday());

		if ((travelOnMonday == null || (travelOnMonday != null && !travelOnMonday))
				&& (travelOnTuesday == null || (travelOnTuesday != null && !travelOnTuesday))
				&& (travelOnWednesday == null || (travelOnWednesday != null && !travelOnWednesday))
				&& (travelOnThursday == null || (travelOnThursday != null && !travelOnThursday))
				&& (travelOnFriday == null || (travelOnFriday != null && !travelOnFriday))
				&& (travelOnSaturday == null || (travelOnSaturday != null && !travelOnSaturday))
				&& (travelOnSunday == null || (travelOnSunday != null && !travelOnSunday))) {

			isValid = false;
		}

		if ((travelOnMonday != null && travelOnMonday && numberOfAvailableSeatsOnMonday == null)
				|| (travelOnTuesday != null && travelOnTuesday && numberOfAvailableSeatsOnTuesday == null)
				|| (travelOnWednesday != null && travelOnWednesday && numberOfAvailableSeatsOnWednesday == null)
				|| (travelOnThursday != null && travelOnThursday && numberOfAvailableSeatsOnThursday == null)
				|| (travelOnFriday != null && travelOnFriday && numberOfAvailableSeatsOnFriday == null)
				|| (travelOnSaturday != null && travelOnSaturday && numberOfAvailableSeatsOnSaturday == null)
				|| (travelOnSunday != null && travelOnSunday && numberOfAvailableSeatsOnSunday == null)) {

			isValid = false;
		}

		return isValid;
	}
}