package com.javaid.bolaky.carpool.service.vo.enumerated;

import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public enum CarPoolError {

	USER_USERNAME_SIZE("S5", "UM1", "Please enter a minimun of 6 characters for username"), 
	USER_USERNAME_NULL("S10", "UM2", "Please enter username"), 
	USER_PASSWORD_SIZE("S15", "UM3", "Please enter a minimun of 8 characters for password"),
	USER_PASSWORD_NULL("S20", "UM4", "Please enter password"),  
	USER_FIRSTNAME_NULL("S25", "UM5", "Please enter firstname"), 
	USER_LASTNAME_NULL("S30", "UM6","Please enter lastname"), 	
	USER_EMAIL_INVALID("S35","UM7","Please enter a valid email"), 
	USER_EMAIL_NULL("S40","UM8","Please enter email"), 
	USER_AGEGROUP_NULL("S45","U25","Please choose age group"), 
	USER_GENDER_NULL("S50","U30","Please choose gender"), 
	USER_VALID_LICENSE_NULL("S55","U35","Please choose valid license"), 
	USER_COUNTRY_CODE_NULL("S60","U50", "Please select country"), 
	USER_AREA_CODE_NULL("S65","U55","Please select area"),
	USER_REGION_CODE_NULL("S70","U60","Please select region"),
	USER_CONFIRM_EMAIL_NULL("S75",null,"Please enter confirm email"),
	USER_CONFIRM_EMAIL_ADDRESS_NOT_MATCH("S76",null,"Email address and confirm email address does not match"),
	USER_CONFIRM_PASSWORD_NULL("S80",null,"Please enter confirm password"),
	USER_CONFIRM_PASSWORD_NOT_MATCH("S81",null,"Password and confirm password does not match"),
	
	FORGOT_PASSWORD_INFO_REQUIRED("S90",null,"Please enter either username or email address"),
	FORGOT_PASSWORD_EMAIL_INVALID("S91",null,"Please enter a valid email"),
	
	FORGOT_PASSWORD_ACCOUNT_NOT_FOUND("S100",null,"Account not found, please enter a valid username or email");
	
	private String applicationCode;
	private String domainErrorCode;
	private String descripion;

	private CarPoolError(String code,String domainErrorCode, String descripion) {
		this.applicationCode = code;
		this.domainErrorCode=domainErrorCode;
		this.descripion = descripion;
	}

	public String getApplicationCode() {
		return applicationCode;
	}
	
	public String getDomainErrorCode() {
		return domainErrorCode;
	}

	public String getDescripion() {
		return descripion;
	}

	public static CarPoolError getCarPoolError(String errorCode) {

		if (errorCode != null) {

			for (CarPoolError carPoolErrorCode : values()) {

				if (carPoolErrorCode.getApplicationCode().equalsIgnoreCase(errorCode)) {
					return carPoolErrorCode;
				}
			}
		}

		return null;
	}

	public static CarPoolError convertFrom(PersonErrorCode personErrorCode) {

		if (personErrorCode != null) {

			for (CarPoolError carPoolErrorCode : values()) {

				if (personErrorCode.getCode().equalsIgnoreCase(carPoolErrorCode.getDomainErrorCode())) {

					return carPoolErrorCode;
				}
			}
		}

		return null;
	}

}
