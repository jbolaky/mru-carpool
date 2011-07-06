package com.javaid.bolaky.carpool.service.impl;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javaid.bolaky.carpool.service.acl.email.api.EmailAcl;
import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;
import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

@Service("carPoolService")
public class DefaultCarPoolService implements CarPoolService {

	@Resource(name = "carpool_service_DefaultUserRegistrationAcl")
	private UserRegistrationAcl userRegistrationAcl;

	@Resource(name = "carpool_service_DefaultEmailAcl")
	private EmailAcl emailAcl;

	private LocationAcl locationAcl;

	public Set<CarPoolError> validate(UserVO userVO) {

		Set<CarPoolError> carPoolErrorCodes = userRegistrationAcl
				.validate(userVO);

		return carPoolErrorCodes;
	}

	public Boolean store(UserVO userVO) {

		return userRegistrationAcl.store(userVO);
	}

	public Set<LocationVO> getAllCountries() {

		return locationAcl.getAllCountries();
	}

	public Boolean emailPassword(String firstname, String lastname,
			String password, String recipientEmailAddress)
			throws EmailAclException {

		String[] emailAddresses = { recipientEmailAddress };
		String subjectOfEmail = "The Car Pool - Forgot Password‏";
		String messageInEmail = "Hi " + firstname + " " + lastname
				+ ",/nHere is your account password:/n" + password
				+ "/nThank you,/nTheCarPool Team";

		return emailAcl.sendEmail(subjectOfEmail, messageInEmail,
				Arrays.asList(emailAddresses));
	}

	public UserVO findByUsernameAndEmailAddress(String username,
			String emailAddress) {

		return userRegistrationAcl.findByUsernameAndEmailAddress(username,
				emailAddress);
	}

	public CarPoolRegistrationVO createCarpoolRegistrationVO(String username) {
		return new CarPoolRegistrationVO(username);
	}

}
