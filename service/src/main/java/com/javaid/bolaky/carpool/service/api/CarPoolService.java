package com.javaid.bolaky.carpool.service.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface CarPoolService {

	Set<CarPoolError> registerUser(UserVO userVO);

	Set<LocationVO> getAllCountries();
}
