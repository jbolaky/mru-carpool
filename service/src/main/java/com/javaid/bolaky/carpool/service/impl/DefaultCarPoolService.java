package com.javaid.bolaky.carpool.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public class DefaultCarPoolService implements CarPoolService {

	@Resource(name = "carpool_service_DefaultUserRegistrationAcl")
	private UserRegistrationAcl userRegistrationAcl;
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

}
