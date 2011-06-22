package com.javaid.bolaky.carpool.service.acl.location.impl;

import java.util.Set;

import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.vo.CountryVO;
import com.javaid.bolaky.domain.location.entity.Country;
import com.javaid.bolaky.domain.location.service.api.LocationService;

public class DefaultLocationAcl implements LocationAcl {

	private LocationService locationService;

	public Set<CountryVO> getAllCountries() {

		Set<Country> countries = locationService.findCountries();
		return LocationAclTranslator.mapCountryVOs(countries);
	}

}
