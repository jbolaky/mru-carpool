package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolErrorCode;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Gender;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public class UserRegistrationAclTranslator {

	public static Person convertToPerson(UserVO userVO) {

		Person person = null;

		if (userVO != null) {

			person = new Person();
			person.setUsername(userVO.getUsername());
			// person.setAgeGroup(AgeGroup.)
			person.setFirstname(userVO.getFirstname());
			person.setLastname(userVO.getLastname());
			person.setPassword(userVO.getPassword());
			person.getContactDetails()
					.setEmailAddress(userVO.getEmailAddress());
			person.setVehicleOwner(userVO.getCarOwner());
			person.setValidLicense(userVO.getValidLicense());
			person.setGender(Gender.convertCode(userVO.getGender()));
			// need to map address
			person.getUserPreferences().setAllowToReceiveUpdates(
					userVO.getAllowToReceiveUpdates());
			person.setShareCost(userVO.getShareCost());
			person.setShareDriving(userVO.getShareDriving());
		}

		return person;
	}

	public static Set<CarPoolErrorCode> convertToCarPoolErrorCodes(
			Set<PersonErrorCode> personErrorCodes) {

		Set<CarPoolErrorCode> carPoolErrorCodes = null;

		if (personErrorCodes != null && !personErrorCodes.isEmpty()) {

			carPoolErrorCodes = new ListOrderedSet<CarPoolErrorCode>();

			for (PersonErrorCode personErrorCode : personErrorCodes) {

				carPoolErrorCodes.add(CarPoolErrorCode
						.convertFrom(personErrorCode));
			}
		}

		return carPoolErrorCodes;
	}
}
