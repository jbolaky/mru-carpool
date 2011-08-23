package com.javaid.bolaky.domain.pools.service.api;

import java.util.List;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

public interface PoolsService {

	Pool save(Pool pool);
	
	Pool find(String username);
	
	Pool find(Long poolId);
	
	List<Pool> findPools(PoolSearchCriteria poolSearchCriteria);
}
