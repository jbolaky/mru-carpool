package com.javaid.bolaky.carpool.service.acl.pools.impl;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.pools.api.PoolsAcl;
import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.service.api.PoolsService;

public class DefaultPoolsAcl implements PoolsAcl {

	@Resource(name = "pools_DefaultService")
	private PoolsService poolsService;

	public Boolean register(CarPoolRegistrationVO carPoolRegistrationVO) {

		Pool pool = poolsService.save(PoolsAclTranslator
				.convertPool(carPoolRegistrationVO));

		return pool != null;
	}

}
