package com.javaid.bolaky.carpool.service.acl.pools.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface PoolsAcl {

	Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO);
	
	Boolean register(PoolRegistrationVO carPoolRegistrationVO);

}
