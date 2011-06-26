package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;
import com.javaid.bolaky.domain.userregistration.hibernate.group.MandatoryDataRules;
import com.javaid.bolaky.domain.userregistration.service.api.UserRegistrationService;

public class DefaultUserRegistrationAcl implements UserRegistrationAcl {

	@Resource(name="user_registration_DefaultService")
	private UserRegistrationService userRegistrationService;

	public Set<CarPoolError> validate(UserVO userVO) {
		Person person = UserRegistrationAclTranslator.convertToPerson(userVO);
		Set<PersonErrorCode> personErrorCodes = person
				.validate(MandatoryDataRules.class);
		return UserRegistrationAclTranslator
				.convertToCarPoolErrorCodes(personErrorCodes);
	}

	public Boolean store(UserVO userVO) {
		Person person = UserRegistrationAclTranslator.convertToPerson(userVO);
		person = userRegistrationService.savePerson(person);
		return person != null ? true : false;
	}

}
