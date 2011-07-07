package com.javaid.bolaky.carpool.service.vo.enumerated;

import static com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView.FORGOT_PASSWORD;
import static com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView.USER_REGISTRATION;
import static com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView.REGISTER_CARPOOL_PAGE_1;
import static com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView.REGISTER_CARPOOL_PAGE_2;
import static com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView.REGISTER_CARPOOL_PAGE_3;

import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public enum CarPoolError {

	USER_USERNAME_SIZE("S5", "UM1", USER_REGISTRATION, "Please enter a minimun of 6 characters for username"), 
	USER_USERNAME_NULL("S10", "UM2", USER_REGISTRATION, "Please enter username"), 
	USER_PASSWORD_SIZE("S15", "UM3", USER_REGISTRATION, "Please enter a minimun of 8 characters for password"),
	USER_PASSWORD_NULL("S20", "UM4", USER_REGISTRATION, "Please enter password"),  
	USER_FIRSTNAME_NULL("S25", "UM5", USER_REGISTRATION, "Please enter firstname"), 
	USER_LASTNAME_NULL("S30", "UM6", USER_REGISTRATION, "Please enter lastname"), 	
	USER_EMAIL_INVALID("S35","UM7", USER_REGISTRATION, "Please enter a valid email"), 
	USER_EMAIL_NULL("S40","UM8", USER_REGISTRATION, "Please enter email"), 
	USER_AGEGROUP_NULL("S45","U25", USER_REGISTRATION, "Please choose age group"), 
	USER_GENDER_NULL("S50","U30", USER_REGISTRATION, "Please choose gender"), 
	USER_VALID_LICENSE_NULL("S55","U35", USER_REGISTRATION, "Please choose valid license"), 
	USER_COUNTRY_CODE_NULL("S60","U50", USER_REGISTRATION, "Please select country"), 
	USER_AREA_CODE_NULL("S65","U55", USER_REGISTRATION, "Please select area"),
	USER_REGION_CODE_NULL("S70","U60", USER_REGISTRATION, "Please select region"),
	USER_CONFIRM_EMAIL_NULL("S75",null, USER_REGISTRATION, "Please enter confirm email"),
	USER_CONFIRM_EMAIL_ADDRESS_NOT_MATCH("S76",null, USER_REGISTRATION, "Email address and confirm email address does not match"),
	USER_CONFIRM_PASSWORD_NULL("S80",null, USER_REGISTRATION, "Please enter confirm password"),
	USER_CONFIRM_PASSWORD_NOT_MATCH("S81",null, USER_REGISTRATION, "Password and confirm password does not match"),
	
	FORGOT_PASSWORD_INFO_REQUIRED("S90",null, FORGOT_PASSWORD, "Please enter either username or email address"),
	FORGOT_PASSWORD_EMAIL_INVALID("S91",null, FORGOT_PASSWORD, "Please enter a valid email"),
	FORGOT_PASSWORD_ACCOUNT_NOT_FOUND("S100",null, FORGOT_PASSWORD, "Account not found, please enter a valid username or email"),
	
	REGISTER_CARPOOL_PAGE_1_CAR_OWNER_NULL("S110",null, REGISTER_CARPOOL_PAGE_1, "Please select car owner"),
	REGISTER_CARPOOL_PAGE_1_VALID_LICENSE_NULL("S115",null, REGISTER_CARPOOL_PAGE_1, "Please select valid license"),
	REGISTER_CARPOOL_PAGE_1_GENDER_NULL("S120",null, REGISTER_CARPOOL_PAGE_1, "Please select gender"),
	REGISTER_CARPOOL_PAGE_1_SMOKER_NULL("S125",null, REGISTER_CARPOOL_PAGE_1, "Please select smoker"),
	REGISTER_CARPOOL_PAGE_1_VEHICLE_MAKE_NULL("S130",null, REGISTER_CARPOOL_PAGE_1, "Please select vehicle make"),
	REGISTER_CARPOOL_PAGE_1_VEHICLE_MODEL_NULL("S135",null, REGISTER_CARPOOL_PAGE_1, "Please select vehicle model"),
	REGISTER_CARPOOL_PAGE_1_VEHICLE_TYPE_NULL("S140",null, REGISTER_CARPOOL_PAGE_1, "Please select vehicle type"),
	
	REGISTER_CARPOOL_PAGE_2_CAR_POOL_NAME_NULL("S145",null, REGISTER_CARPOOL_PAGE_2, "Please enter a car pool name"),
	REGISTER_CARPOOL_PAGE_2_CAR_POOL_DATE_NULL("S150",null, REGISTER_CARPOOL_PAGE_2, "Please enter car pool date"),
	REGISTER_CARPOOL_PAGE_2_NUMBER_PASSENGER_NULL("S155",null, REGISTER_CARPOOL_PAGE_2, "Please enter of current passengers"),
	REGISTER_CARPOOL_PAGE_2_FROM_AREA_CODE_NULL("S160",null, REGISTER_CARPOOL_PAGE_2, "Please select area"),
	REGISTER_CARPOOL_PAGE_2_FROM_DISTRICT_NULL("S165",null, REGISTER_CARPOOL_PAGE_2, "Please select district"),
	REGISTER_CARPOOL_PAGE_2_TRAVEL_TYPE_NULL("S170",null, REGISTER_CARPOOL_PAGE_2, "Please select travel type"),
	REGISTER_CARPOOL_PAGE_2_GENDER_TO_TRAVEL_WITH_NULL("S175",null, REGISTER_CARPOOL_PAGE_2, "Please select preffered gender to travel with"),
	REGISTER_CARPOOL_PAGE_2_SHARE_COST_NULL("S180",null, REGISTER_CARPOOL_PAGE_2, "Please select share cost"),
	
	REGISTER_CARPOOL_PAGE_3_TRAVEL_DAY_SEAT_NULL("S200",null, REGISTER_CARPOOL_PAGE_3, "Please select at least a travel day and enter its number of available seats"),
	REGISTER_CARPOOL_PAGE_3_DEPARTURE_DATE_NULL("S205",null, REGISTER_CARPOOL_PAGE_3, "Please select departure date"),
	REGISTER_CARPOOL_PAGE_3_TO_AREA_CODE_NULL("S210",null, REGISTER_CARPOOL_PAGE_3, "select area"),
	REGISTER_CARPOOL_PAGE_3_TO_DISTRICT_CODE_NULL("S215",null, REGISTER_CARPOOL_PAGE_3, "Please select district");
	
	private String applicationCode;
	private String domainErrorCode;
	private CarPoolView carPoolView;
	private String descripion;

	private CarPoolError(String code,String domainErrorCode, CarPoolView carPoolView, String descripion) {
		this.applicationCode = code;
		this.domainErrorCode=domainErrorCode;
		this.carPoolView=carPoolView;
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
	
	public CarPoolView getCarPoolView() {
		return carPoolView;
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

	public static Boolean isApplicationCodeCorrespondsToView(String applicationCode,CarPoolView carPoolViews){
		
		boolean corresponds = false;
		
		for (CarPoolError carPoolErrorCode : values()) {
			
			if(carPoolErrorCode.getApplicationCode().equals(applicationCode) && carPoolErrorCode.getCarPoolView().equals(carPoolViews)){
				corresponds = true;
				break;
			}
		}
		
		return corresponds;
	}
}
