package com.javaid.bolaky.carpool.service.vo.enumerated;

import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public enum CarPoolError {

	USER_USERNAME_NULL("S11", "Please enter username"), 
	USER_USERNAME_SIZE("S12", "Please enter a minimun of 6 characters for username"), 
	USER_PASSWORD_NULL("S13", "Please enter password"), 
	USER_PASSWORD_SIZE("S14","Please enter a minimun of 8 characters for password"), 
	USER_FIRSTNAME_NULL("S15", "Please enter firstname"), 
	USER_LASTNAME_NULL("S16","Please enter lastname"), 
	USER_AGEGROUP_NULL("S17","Please choose your appropriate age group"), 
	USER_GENDER_NULL("S18","Please choose gender"), 
	USER_VALID_LICENSE_NULL("S19","Please choose if you have a valid license"), 
	USER_EMAIL_INVALID("S21","Please a valid email address"), 
	USER_EMAIL_NULL("S20","Please enter email address"), 
	USER_ADDRESS_NULL("S22","Please enter address"), 
	USER_COUNTRY_CODE_NULL("S24", "Please select your country"), 
	USER_AREA_CODE_NULL("S25","Please select your area"),
	USER_REGION_CODE_NULL("S26","Please select your region"),
	USER_CONFIRM_EMAIL_ADDRESS_NOT_MATCH("S27","Email address and confirm email address fields does not match"),
	USER_CONFIRM_PASSWORD_NOT_MATCH("S28","Password and confirm password fields does not match");

	private String code;
	private String descripion;

	private CarPoolError(String code, String descripion) {
		this.code = code;
		this.descripion = descripion;
	}

	public String getCode() {
		return code;
	}

	public String getDescripion() {
		return descripion;
	}

	public static CarPoolError getCarPoolError(String errorCode) {

		if (errorCode != null) {

			for (CarPoolError carPoolErrorCode : values()) {

				if (carPoolErrorCode.getCode().equalsIgnoreCase(errorCode)) {
					return carPoolErrorCode;
				}
			}
		}

		return null;
	}

	public static CarPoolError convertFrom(PersonErrorCode personErrorCode) {

		if (personErrorCode != null) {

			for (CarPoolError carPoolErrorCode : values()) {

				if (carPoolErrorCode.getCode().equalsIgnoreCase(
						personErrorCode.getCode())) {

					return carPoolErrorCode;
				}
			}
		}

		return null;
	}

}
