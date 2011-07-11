package com.javaid.bolaky.carpool.service.acl.pools.impl;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.pools.api.PoolsAcl;
import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.domain.pools.service.api.PoolsService;

public class DefaultPoolsAcl implements PoolsAcl {

	@Resource(name="pools_DefaultService")
	private PoolsService poolsService;
	
	public Boolean register(CarPoolRegistrationVO carPoolRegistrationVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
