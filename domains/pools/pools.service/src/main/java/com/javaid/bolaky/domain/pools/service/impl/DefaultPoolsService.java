package com.javaid.bolaky.domain.pools.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.repository.api.PoolsRepository;
import com.javaid.bolaky.domain.pools.service.api.PoolsService;

@Transactional(readOnly = true)
public class DefaultPoolsService implements PoolsService {

	@Resource(name = "poolsRepository")
	private PoolsRepository poolsRepository;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Pool save(Pool pool) {

		return poolsRepository.save(pool);
	}

	public Pool find(String username) {

		return poolsRepository.findByUsername(username);
	}

}
