package com.javaid.bolaky.carpool.service.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.ForgotPasswordAttributeCheck;
import com.javaid.bolaky.carpool.service.vo.ForgotPasswordVO;

public class ForgotPasswordAttributeCheckValidator implements
		ConstraintValidator<ForgotPasswordAttributeCheck, ForgotPasswordVO> {

	public void initialize(ForgotPasswordAttributeCheck constraintAnnotation) {

	}

	public boolean isValid(ForgotPasswordVO forgotPasswordVO,
			ConstraintValidatorContext context) {

		boolean isValid = true;

		if ((forgotPasswordVO.getEmailAddress() == null || (forgotPasswordVO
				.getEmailAddress() != null && forgotPasswordVO
				.getEmailAddress().equals("")))
				&& (forgotPasswordVO.getUsername() == null || (forgotPasswordVO
						.getUsername() != null && forgotPasswordVO
						.getUsername().equals("")))) {

			isValid = false;
		}

		return isValid;
	}

}
