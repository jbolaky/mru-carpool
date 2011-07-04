package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
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
import com.javaid.bolaky.domain.userregistration.service.api.UserRegistrationService;

public class DefaultUserRegistrationAcl implements UserRegistrationAcl {

	@Resource(name = "user_registration_DefaultService")
	private UserRegistrationService userRegistrationService;

	public Set<CarPoolError> validate(UserVO userVO) {

		Person person = UserRegistrationAclTranslator.convertToPerson(userVO);

		Set<PersonErrorCode> personErrorCodes = person.validate(
				MandatoryDataRules.class, AddressDataRule.class,
				AreaCodeDataRule.class, CountryCodeDataRule.class,
				DistrictCodeDataRule.class, AgeGroupDataRule.class,
				GenderDataRule.class, ValidLicenseDataRule.class);

		return UserRegistrationAclTranslator
				.convertToCarPoolErrorCodes(personErrorCodes);
	}

	public Boolean store(UserVO userVO) {

		Person person = UserRegistrationAclTranslator.convertToPerson(userVO);
		person = userRegistrationService.savePerson(person);
		return person != null ? true : false;
	}

	public UserVO findByUsernameAndEmailAddress(String username,
			String emailAddress) {

		Person person = userRegistrationService.findByUsernameAndEmailAddress(
				username, emailAddress);
		return UserRegistrationAclTranslator.convertToUserVO(person);
	}

}
