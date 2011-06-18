package com.javaid.bolaky.carpool.service.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolErrorCode;

public interface CarPoolService {

	Set<CarPoolErrorCode> registerUserAndSendEmail(UserVO userVO);
}
