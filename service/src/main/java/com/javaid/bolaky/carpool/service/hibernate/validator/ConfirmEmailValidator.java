package com.javaid.bolaky.carpool.service.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.ConfirmEmailCheck;
import com.javaid.bolaky.carpool.service.vo.UserVO;

public class ConfirmEmailValidator implements
		ConstraintValidator<ConfirmEmailCheck, UserVO> {

	public void initialize(ConfirmEmailCheck emailsEnteredCheck) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(UserVO userVO, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (userVO.getConfirmEmailAddress() == null
				|| userVO.getConfirmEmailAddress().equals("")) {

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("S75")
					.addConstraintViolation();
			isValid = false;
		} else if (!userVO.getConfirmEmailAddress().equals(
				userVO.getEmailAddress())) {
			isValid = false;
		}

		return isValid;
	}
}