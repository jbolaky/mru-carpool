package com.javaid.bolaky.carpool.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.util.Assert;

import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public class DefaultCarPoolService implements CarPoolService {

	@Resource(name="carpool_service_DefaultUserRegistrationAcl")
	private UserRegistrationAcl userRegistrationAcl;
	private LocationAcl locationAcl;

	public Set<CarPoolError> registerUser(UserVO userVO) {

		Set<CarPoolError> carPoolErrorCodes = userRegistrationAcl
				.validate(userVO);

		if (carPoolErrorCodes == null) {
			Assert.isTrue(userRegistrationAcl.store(userVO),
					"Was expected to be true, may be a hardware failure");
		}

		return carPoolErrorCodes;
	}

	public Set<LocationVO> getAllCountries() {

		return locationAcl.getAllCountries();
	}

}
