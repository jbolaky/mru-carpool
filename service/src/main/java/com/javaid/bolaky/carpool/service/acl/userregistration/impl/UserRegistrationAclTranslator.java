package com.javaid.bolaky.carpool.service.acl.userregistration.impl;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.AgeGroup;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.userregistration.entity.Address;
import com.javaid.bolaky.domain.userregistration.entity.Authority;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.entity.enumerated.Gender;
import com.javaid.bolaky.domain.userregistration.enumerated.PersonErrorCode;

public class UserRegistrationAclTranslator {

	public static Person convertToPerson(UserVO userVO, Person person) {

		if (userVO != null) {

			person.setUsername(userVO.getUsername());
			person.setAgeGroup(userVO.getAgeGroup() != null ? com.javaid.bolaky.domain.userregistration.entity.enumerated.AgeGroup
					.convertCode(userVO.getAgeGroup().getCode()) : null);
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
			
			/*Authority authority = new Authority();
			authority.getRole();
			
			person.addAuthority(authority);*/
		}

		return person;
	}

	public static UserVO convertToUserVO(Person person) {

		UserVO userVO = null;

		if (person != null) {

			userVO = new UserVO();

			userVO.setUsername(person.getUsername());
			userVO.setAgeGroup(person.getAgeGroup() != null ? AgeGroup
					.convertCode(person.getAgeGroup().getCode()) : null);
			userVO.setFirstname(person.getFirstname());
			userVO.setLastname(person.getLastname());
			userVO.setPassword(person.getPassword());
			userVO.setEmailAddress(person.getContactDetails() != null ? person
					.getContactDetails().getEmailAddresse() : null);
			userVO.setCarOwner(person.isAVehicleOwner());
			userVO.setValidLicense(person.hasValidLicense());
			userVO.setGender(person.getGender().getCode());

			Set<Address> addresses = person.getContactDetails() != null ? person
					.getContactDetails().getAddresses() : null;

			if (addresses != null) {

				Iterator<Address> iterator = addresses.iterator();

				if (iterator.hasNext()) {

					Address address = iterator.next();
					userVO.setCountryCode(address.getCountryCode());
					userVO.setAreaCode(address.getAreaCode());
					userVO.setDistrictCode(address.getDistrictCode());
					userVO.setAddressLine1(address.getAddressLine1());

				}
			}

			userVO.setPhoneNumber(person.getContactDetails() != null ? person
					.getContactDetails().getPhoneNumber() : null);
			userVO.setAllowToReceiveUpdates(person.getUserPreferences() != null ? person
					.getUserPreferences().isAllowToReceiveUpdates() : null);
			userVO.setShareCost(person.canShareCost());
			userVO.setShareDriving(person.canShareDriving());

		}

		return userVO;
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
