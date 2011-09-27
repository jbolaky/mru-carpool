package com.javaid.bolaky.carpool.service.acl.location.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.LocationVO;

public interface LocationAcl {

	Set<LocationVO> getAllCountries();
	
	Set<LocationVO> getAreas(Long countryId);
	
	Set<LocationVO> getDistricts(Long areaId);
}
