package com.javaid.bolaky.carpool.service.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface CarPoolService {

	Set<CarPoolError> validate(UserVO userVO);
	
	Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO);

	Boolean store(UserVO userVO);

	Set<LocationVO> getAllCountries();

	Boolean emailPassword(String firstname, String lastname, String password,
			String recipientEmailAddress) throws EmailAclException;

	UserVO findByUsernameAndEmailAddress(String username, String emailAddress);
	
	PoolRegistrationVO createCarpoolRegistrationVO(String username);
	
	void printCarPoolRegistrationVO(PoolRegistrationVO carPoolRegistrationVO);
}
