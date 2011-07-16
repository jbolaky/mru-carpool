package com.javaid.bolaky.carpool.service.acl.pools.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.pools.api.PoolsAcl;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;
import com.javaid.bolaky.domain.pools.service.api.PoolsService;

public class DefaultPoolsAcl implements PoolsAcl {

	@Resource(name = "pools_DefaultService")
	private PoolsService poolsService;

	public Set<CarPoolError> validate(
			PoolRegistrationVO carPoolRegistrationVO) {

		Set<PoolsError> poolsErrors = PoolsAclTranslator.convertPool(
				carPoolRegistrationVO).activate();

		return PoolsAclTranslator.convertToCarPoolErrors(poolsErrors);
	}

	public Boolean register(PoolRegistrationVO carPoolRegistrationVO) {

		Pool pool = poolsService.save(PoolsAclTranslator
				.convertPool(carPoolRegistrationVO));

		return pool != null;
	}

}
