package com.javaid.bolaky.domain.userregistration.enumerated;

public enum PersonErrorCode {

	
	PERSON_USERNAME_SIZE("UM1","username size should be of minimum 6 lenght"),
	PERSON_USERNAME_NULL("UM2","username cannot be null"),
	PERSON_PASSWORD_SIZE("UM3","password size should be of minimum 8 lenght"),
	PERSON_PASSWORD_NULL("UM4","password cannot be null"),
	PERSON_FIRSTNAME_NULL("UM5","firstname cannot be null"),
	PERSON_LASTNAME_NULL("UM6","lastname cannot be null"),
	PERSON_EMAIL_INVALID("UM7","email not in correct format"),
	PERSON_EMAIL_NULL("UM8","email address cannot be null"),
	PERSON_AGEGROUP_NULL("U25","age group cannot be null"),
	PERSON_GENDER_NULL("U30","gender cannot be null"),
	PERSON_VALID_LICENSE_NULL("U35","valid license cannot be null"),
	PERSON_AGE_CONSTRAINT("U36","person having a valid license should be at least 18 years old"),
	PERSON_LIST_OF_ADDRESS_NULL("U40","list of addresses cannot be null"),
	PERSON_LIST_OF_ADDRESS_ZERO("U45","should contain at least one address"),
	PERSON_ADDRESS_COUNTRY_CODE_NULL("U50","country code cannot be null"),
	PERSON_ADDRESS_AREA_CODE_NULL("U55","area code cannot be null"),
	PERSON_ADDRESS_DISTRICT_CODE_NULL("U60","district code cannot be null");

	private String code;
	private String descripion;

	private PersonErrorCode(String code,String descripion) {
		this.code = code;
		this.descripion=descripion;
	}

	public String getCode() {
		return code;
	}

	public String getDescripion() {
		return descripion;
	}

	public static PersonErrorCode convertFrom(String code) {

		if (code != null) {

			for (PersonErrorCode personErrorCode : values()) {

				if (code.equalsIgnoreCase(personErrorCode.getCode())) {

					return personErrorCode;
				}
			}
		}

		return null;
	}
}
