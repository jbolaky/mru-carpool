package com.javaid.bolaky.carpool.service.acl.pools.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.pools.api.PoolsAcl;
import com.javaid.bolaky.carpool.service.vo.ContactDriverVO;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;
import com.javaid.bolaky.domain.pools.service.api.PoolsService;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

public class DefaultPoolsAcl implements PoolsAcl {

	@Resource(name = "pools_DefaultService")
	private PoolsService poolsService;

	public Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO) {

		Set<PoolsError> poolsErrors = PoolsAclTranslator.convertPool(
				carPoolRegistrationVO).activate();

		return PoolsAclTranslator.convertToCarPoolErrors(poolsErrors);
	}

	public Boolean register(PoolRegistrationVO carPoolRegistrationVO) {

		Pool pool = PoolsAclTranslator.convertPool(carPoolRegistrationVO);
		pool.setAgeGroup(AgeGroup.TWENTY_ONE_TO_TWENTYFIVE);
		Set<PoolsError> poolsErrors = pool.activate();

		if (poolsErrors == null
				|| (poolsErrors != null && poolsErrors.isEmpty())) {

			pool = poolsService.save(pool);
		}

		return pool != null;
	}

	public Set<PoolSearchResultVO> findAvailablePools(PoolSearchVO poolSearchVO) {

		PoolSearchCriteria poolSearchCriteria = PoolsAclTranslator
				.convert(poolSearchVO);

		List<Pool> pools = poolsService.findPools(poolSearchCriteria);
		return PoolsAclTranslator.convert(pools);
	}

	public PoolVO findPool(Long poolId) {

		Pool pool = poolsService.find(poolId);
		return PoolsAclTranslator.convertToPoolVO(pool);
	}

	public Boolean addPassengerToPool(ContactDriverVO contactDriverVO) {
		
		Pool pool = poolsService.find(contactDriverVO.getPoolId());
		pool.addPassengers(PoolsAclTranslator.convert(contactDriverVO));
		
		Set<PoolsError> poolsErrors = pool.activate();

		if (poolsErrors == null
				|| (poolsErrors != null && poolsErrors.isEmpty())) {

			pool = poolsService.save(pool);
		}

		return pool != null;
	}

}
