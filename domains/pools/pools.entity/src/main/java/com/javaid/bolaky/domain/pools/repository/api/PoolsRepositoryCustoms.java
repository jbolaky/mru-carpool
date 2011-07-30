package com.javaid.bolaky.domain.pools.repository.api;

import java.util.List;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

public interface PoolsRepositoryCustoms {

	List<Pool> findPool(PoolSearchCriteria poolSearchCriteria);
}
