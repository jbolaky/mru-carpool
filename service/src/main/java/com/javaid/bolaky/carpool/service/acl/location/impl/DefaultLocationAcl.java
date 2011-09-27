package com.javaid.bolaky.carpool.service.acl.location.impl;

import java.util.Set;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.domain.location.entity.Area;
import com.javaid.bolaky.domain.location.entity.Country;
import com.javaid.bolaky.domain.location.service.api.LocationService;

public class DefaultLocationAcl implements LocationAcl {

	@Resource(name = "location_domain_DefaultLocationService")
	private LocationService locationService;

	public Set<LocationVO> getAllCountries() {

		Set<Country> countries = locationService.findCountries();
		return LocationAclTranslator.mapCountries(countries);
	}

	public Set<LocationVO> getAreas(Long countryId) {

		Country country = locationService.findCountry(countryId);
		return LocationAclTranslator.mapAreas(country != null ? country
				.getAreas() : null);
	}

	public Set<LocationVO> getDistricts(Long areaId) {

		Area area = locationService.findArea(areaId);
		return LocationAclTranslator.mapDistricts(area != null ? area
				.getDistricts() : null);
	}

}
