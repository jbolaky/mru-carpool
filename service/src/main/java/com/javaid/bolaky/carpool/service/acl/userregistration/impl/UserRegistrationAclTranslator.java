package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.userregistration.entity.Address;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Gender;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public class UserRegistrationAclTranslator {

	public static Person convertToPerson(UserVO userVO) {

		Person person = null;

		if (userVO != null) {

			person = new Person();
			person.setUsername(userVO.getUsername());
			person.setAgeGroup(AgeGroup.convertCode(userVO.getAgeGroup()));
			person.setFirstname(userVO.getFirstname());
			person.setLastname(userVO.getLastname());
			person.setPassword(userVO.getPassword());
			person.setVehicleOwner(userVO.getCarOwner());
			person.setValidLicense(userVO.getValidLicense());
			person.setGender(Gender.convertCode(userVO.getGender()));
			person.setShareCost(userVO.getShareCost());
			person.setShareDriving(userVO.getShareDriving());

			person.getUserPreferences().setAllowToReceiveUpdates(
					userVO.getAllowToReceiveUpdates());

			person.getContactDetails().setPhoneNumber(userVO.getPhoneNumber());
			person.getContactDetails()
					.setEmailAddress(userVO.getEmailAddress());
			person.getContactDetails().addAddress(
					new Address(userVO.getAddressLine1(), userVO
							.getCountryCode(), null, userVO.getAreaCode(),
							userVO.getDistrictCode()));
		}

		return person;
	}

	public static Set<CarPoolError> convertToCarPoolErrorCodes(
			Set<PersonErrorCode> personErrorCodes) {

		Set<CarPoolError> carPoolErrorCodes = null;

		if (personErrorCodes != null && !personErrorCodes.isEmpty()) {

			carPoolErrorCodes = new ListOrderedSet<CarPoolError>();

			for (PersonErrorCode personErrorCode : personErrorCodes) {

				CarPoolError carPoolError = CarPoolError
						.convertFrom(personErrorCode);

				if (carPoolError != null) {
					carPoolErrorCodes.add(carPoolError);
				}
			}
		}

		return carPoolErrorCodes;
	}
}
