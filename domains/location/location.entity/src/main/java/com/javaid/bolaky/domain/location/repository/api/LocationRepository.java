package com.javaid.bolaky.domain.location.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaid.bolaky.domain.location.entity.Country;

public interface LocationRepository extends JpaRepository<Country, Long> {

}
