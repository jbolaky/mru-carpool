package com.javaid.bolaky.domain.location.service.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaid.bolaky.domain.location.entity.Country;
import com.javaid.bolaky.domain.location.repository.api.LocationRepository;
import com.javaid.bolaky.domain.location.service.api.LocationService;

public class DefaultLocationService implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public Set<Country> findCountries() {
		return ListOrderedSet.decorate(locationRepository.findAll());
	}

}
