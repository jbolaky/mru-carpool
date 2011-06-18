package com.javaid.bolaky.carpool.service.acl.userregistration.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolErrorCode;

public interface UserRegistrationAcl {

	Set<CarPoolErrorCode> validate(UserVO userVO);

	Boolean store(UserVO userVO);
}
