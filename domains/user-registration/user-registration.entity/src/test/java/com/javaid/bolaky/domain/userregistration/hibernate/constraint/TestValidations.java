package com.javaid.bolaky.domain.userregistration.hibernate.constraint;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

import com.javaid.bolaky.domain.userregistration.entity.Address;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;
import com.javaid.bolaky.domain.userregistration.hibernate.group.AddressDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.AgeGroupDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.AreaCodeDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.CountryCodeDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.DistrictCodeDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.GenderDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.MandatoryDataRules;
import com.javaid.bolaky.domain.userregistration.hibernate.group.ValidLicenseDataRule;

public class TestValidations {

	@Test
	public void testGettingErrorFromAgeWithLicenseCheck() {

		Person person = new Person();
		person.setValidLicense(true);

		Set<PersonErrorCode> personErrorCodes = person
				.validate(ValidLicenseDataRule.class);

		assertThat(
				isPresent(PersonErrorCode.PERSON_AGE_CONSTRAINT,
						personErrorCodes), is(true));
	}

	@Test
	public void testGettingConstraintsWhenPersonIsEmpty() {

		Person person = new Person();

		Set<PersonErrorCode> personErrorCodes = person.validate(
				MandatoryDataRules.class, AddressDataRule.class,
				AgeGroupDataRule.class, GenderDataRule.class,
				ValidLicenseDataRule.class);

		assertThat(personErrorCodes.size(), is(10));
	}

	@Test
	public void testInvalidEmailConstraint() {

		Person person = new Person();
		person.getContactDetails().setEmailAddress("a");

		Set<PersonErrorCode> personErrorCodes = person
				.validate(MandatoryDataRules.class);

		assertThat(
				isPresent(PersonErrorCode.PERSON_EMAIL_INVALID,
						personErrorCodes), is(true));
	}

	@Test
	public void testValidEmailConstraint() {

		Person person = new Person();
		person.getContactDetails().setEmailAddress("javaid@gmail.com");

		Set<PersonErrorCode> personErrorCodes = person
				.validate(MandatoryDataRules.class);

		assertThat(
				isPresent(PersonErrorCode.PERSON_EMAIL_INVALID,
						personErrorCodes), is(false));
	}

	@Test
	public void testProvidedInvalidAddressConstraint() {

		Person person = new Person();
		Address address = new Address(null, null, null, null, null);
		person.getContactDetails().setEmailAddress("javaid@gmail.com");
		person.getContactDetails().addAddress(address);

		Set<PersonErrorCode> personErrorCodes = person.validate(
				MandatoryDataRules.class, AddressDataRule.class,
				CountryCodeDataRule.class, AreaCodeDataRule.class,
				DistrictCodeDataRule.class);

		assertThat(
				isPresent(PersonErrorCode.PERSON_EMAIL_INVALID,
						personErrorCodes), is(false));
		assertThat(
				isPresent(PersonErrorCode.PERSON_LIST_OF_ADDRESS_ZERO,
						personErrorCodes), is(false));
		assertThat(
				isPresent(PersonErrorCode.PERSON_ADDRESS_COUNTRY_CODE_NULL,
						personErrorCodes), is(true));
		assertThat(
				isPresent(PersonErrorCode.PERSON_ADDRESS_AREA_CODE_NULL,
						personErrorCodes), is(true));
		assertThat(
				isPresent(PersonErrorCode.PERSON_ADDRESS_DISTRICT_CODE_NULL,
						personErrorCodes), is(true));
	}

	private boolean isPresent(PersonErrorCode personErrorCode,
			Set<PersonErrorCode> personErrorCodes) {

		boolean hasFound = false;
		for (PersonErrorCode personError : personErrorCodes) {

			if (personError.equals(personErrorCode)) {
				hasFound = true;
				break;
			}
		}
		return hasFound;
	}
}
