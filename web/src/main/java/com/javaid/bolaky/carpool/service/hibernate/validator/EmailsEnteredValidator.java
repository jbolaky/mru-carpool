package com.javaid.bolaky.carpool.service.hibernate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javaid.bolaky.carpool.service.hibernate.constraint.EmailsEnteredCheck;
import com.javaid.bolaky.carpool.service.vo.UserVO;

public class EmailsEnteredValidator implements
		ConstraintValidator<EmailsEnteredCheck, UserVO> {

	public void initialize(EmailsEnteredCheck emailsEnteredCheck) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(UserVO userVO, ConstraintValidatorContext context) {

		boolean isValid = false;

		if (userVO.getEmailAddress() == null
				&& userVO.getConfirmEmailAddress() == null) {
			return isValid;
		}

		if ((userVO.getEmailAddress() != null && userVO.getEmailAddress()
				.equals(userVO.getConfirmEmailAddress()))) {
			isValid = true;
		}

		return isValid;
	}

}