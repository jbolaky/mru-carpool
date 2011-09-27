package com.javaid.bolaky.domain.location.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaid.bolaky.domain.location.entity.Area;
import com.javaid.bolaky.domain.location.entity.Country;

public interface LocationRepository extends JpaRepository<Country, Long> {

	@Query(value = "SELECT DISTINCT c from Country c INNER JOIN c.areas a WHERE a.areaId =:areaId")
	Country findCountry(@Param("areaId") Long areaId);

	@Query(value = "SELECT DISTINCT a from Area a WHERE a.areaId =:areaId")
	Area findArea(@Param("areaId") Long areaId);
}
