package com.javaid.bolaky.carpool.service.acl.pools.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface PoolsAcl {

	Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO);

	Boolean register(PoolRegistrationVO carPoolRegistrationVO);

	Set<PoolSearchResultVO> findAvailablePools(PoolSearchVO poolSearchVO);

	PoolVO findPool(Long poolId);
}
