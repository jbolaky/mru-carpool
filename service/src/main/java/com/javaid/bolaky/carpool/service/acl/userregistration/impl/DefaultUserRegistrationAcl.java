package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Set;

import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolErrorCode;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;
import com.javaid.bolaky.domain.userregistration.hibernate.group.MandatoryDataRules;
import com.javaid.bolaky.domain.userregistration.service.api.UserRegistrationService;

public class DefaultUserRegistrationAcl implements UserRegistrationAcl {

	private UserRegistrationService userRegistrationService;

	public Set<CarPoolErrorCode> validate(UserVO userVO) {
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
