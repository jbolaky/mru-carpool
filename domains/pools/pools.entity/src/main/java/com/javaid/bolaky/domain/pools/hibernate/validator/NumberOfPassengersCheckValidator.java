package com.javaid.bolaky.domain.pools.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.hibernate.constraint.NumberOfPassengersCheck;

public class NumberOfPassengersCheckValidator implements
		ConstraintValidator<NumberOfPassengersCheck, Pool> {

	public void initialize(NumberOfPassengersCheck constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(Pool pool, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (pool.getNumberOfCurrentPassengers() != null
				&& pool.getVehicleInfo() != null
				&& pool.getVehicleInfo().getMaxNumberOfSeats() != null) {

			isValid = pool.getNumberOfCurrentPassengers() < pool
					.getVehicleInfo().getMaxNumberOfSeats();
		}

		return isValid;
	}

}