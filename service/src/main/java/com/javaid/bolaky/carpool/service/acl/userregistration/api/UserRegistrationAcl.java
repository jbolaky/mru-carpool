package com.javaid.bolaky.carpool.service.acl.userregistration.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface UserRegistrationAcl {

	Set<CarPoolError> validate(UserVO userVO);

	Boolean store(UserVO userVO);

	UserVO findByUsernameAndEmailAddress(String username, String emailAddress);

}
