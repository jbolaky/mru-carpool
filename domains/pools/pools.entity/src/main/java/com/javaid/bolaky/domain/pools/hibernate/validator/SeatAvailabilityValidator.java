package com.javaid.bolaky.domain.pools.hibernate.validator;

import java.util.Map.Entry;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.hibernate.constraint.SeatAvailability;

public class SeatAvailabilityValidator implements
		ConstraintValidator<SeatAvailability, Pool> {

	public void initialize(SeatAvailability constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(Pool pool, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (pool.getVehicleInfo().getMaxNumberOfSeats() != null
				&& pool.getNumberOfCurrentPassengers() != null) {

			final Integer numberSeatsLeftEachDay = pool.getVehicleInfo()
					.getMaxNumberOfSeats()
					- pool.getNumberOfCurrentPassengers();

			for (Entry<DayOfWeek, Integer> numberOfSeatsAvailableAndDays : pool
					.getTravelDaysAndAvailableSeats().entrySet()) {

				if (numberOfSeatsAvailableAndDays.getValue() != null
						&& numberOfSeatsAvailableAndDays.getValue() > numberSeatsLeftEachDay) {

					isValid = false;
					context.disableDefaultConstraintViolation();

					switch (numberOfSeatsAvailableAndDays.getKey()) {

					case MONDAY:
						context.buildConstraintViolationWithTemplate("P201")
								.addConstraintViolation();
						break;
					case TUESDAY:
						context.buildConstraintViolationWithTemplate("P202")
								.addConstraintViolation();
						break;
					case WEDNESDAY:
						context.buildConstraintViolationWithTemplate("P203")
								.addConstraintViolation();
						break;
					case THURSDAY:
						context.buildConstraintViolationWithTemplate("P204")
								.addConstraintViolation();
						break;
					case FRIDAY:
						context.buildConstraintViolationWithTemplate("P205")
								.addConstraintViolation();
						break;
					case SATURDAY:
						context.buildConstraintViolationWithTemplate("P206")
								.addConstraintViolation();
						break;
					case SUNDAY:
						context.buildConstraintViolationWithTemplate("P207")
								.addConstraintViolation();
						break;

					default:
						break;
					}
				}
			}
		}

		return isValid;
	}
}
