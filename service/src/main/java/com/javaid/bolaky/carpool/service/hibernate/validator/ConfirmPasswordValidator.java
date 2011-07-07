package com.javaid.bolaky.carpool.service.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.ConfirmPassword;
import com.javaid.bolaky.carpool.service.vo.UserVO;

public class ConfirmPasswordValidator implements
		ConstraintValidator<ConfirmPassword, UserVO> {

	public void initialize(ConfirmPassword passwords) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(UserVO userVO, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (userVO.getConfirmPassword() == null
				|| userVO.getConfirmPassword().equals("")) {

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("S80")
					.addConstraintViolation();
			isValid = false;
		} else if (!userVO.getConfirmPassword().equals(userVO.getPassword())) {
			isValid = false;
		}

		return isValid;
	}

}