package com.javaid.bolaky.domain.pools.service.api;

import com.javaid.bolaky.domain.pools.entity.Pool;

public interface PoolsService {

	Pool save(Pool pool);
	
	Pool find(String username);
}
