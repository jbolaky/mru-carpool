package com.javaid.bolaky.domain.pools.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaid.bolaky.domain.pools.entity.Pool;

public interface PoolsRepository extends JpaRepository<Pool, Long> {

	@Query(value = "select p from Pool p where p.username =:username")
	Pool findByUsername(@Param("username") String username);
}
