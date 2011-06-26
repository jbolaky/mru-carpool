package com.javaid.bolaky.carpool.service.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.PasswordsEnteredCheck;
import com.javaid.bolaky.carpool.service.vo.UserVO;

public class PasswordsEnteredValidator implements
		ConstraintValidator<PasswordsEnteredCheck, UserVO> {

	public void initialize(PasswordsEnteredCheck passwords) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(UserVO userVO, ConstraintValidatorContext context) {

		boolean isValid = false;

		if (userVO.getPassword() == null && userVO.getConfirmPassword() == null) {
			return isValid;
		}

		if ((userVO.getPassword() != null && userVO.getPassword().equals(
				userVO.getConfirmPassword()))) {
			isValid = true;
		}

		return isValid;
	}

}