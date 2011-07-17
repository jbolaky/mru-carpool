package com.javaid.bolaky.domain.pools.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.hibernate.constraint.PoolEndDate;

public class PoolEndDateValidator implements
		ConstraintValidator<PoolEndDate, Pool> {

	public void initialize(PoolEndDate constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(Pool pool, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (pool.getStartingPointInfo() != null
				&& pool.getStartingPointInfo().getStartingDate() != null
				&& pool.getDestinationInfo() != null
				&& pool.getDestinationInfo().getEndDate() != null) {

			isValid = pool.getDestinationInfo().getEndDate()
					.isEqual(pool.getStartingPointInfo().getStartingDate())
					|| pool.getDestinationInfo()
							.getEndDate()
							.isAfter(
									pool.getStartingPointInfo()
											.getStartingDate());
		}

		return isValid;
	}
}
