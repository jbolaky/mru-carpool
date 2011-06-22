package com.javaid.bolaky.carpool.service.impl;

import java.util.Set;

import org.springframework.util.Assert;

import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.CountryVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolErrorCode;

public class DefaultCarPoolService implements CarPoolService {

	private UserRegistrationAcl userRegistrationAcl;
	private LocationAcl locationAcl;

	public Set<CarPoolErrorCode> registerUser(UserVO userVO) {

		Set<CarPoolErrorCode> carPoolErrorCodes = userRegistrationAcl
				.validate(userVO);

		if (carPoolErrorCodes == null) {
			Assert.isTrue(userRegistrationAcl.store(userVO),
					"Was expected to be true, may be a hardware failure");
		}

		return carPoolErrorCodes;
	}

	public Set<CountryVO> getAllCountries() {

		return locationAcl.getAllCountries();
	}

}
