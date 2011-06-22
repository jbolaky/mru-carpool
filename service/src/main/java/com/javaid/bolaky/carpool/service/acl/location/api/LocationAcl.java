package com.javaid.bolaky.carpool.service.acl.location.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.vo.CountryVO;

public interface LocationAcl {

	Set<CountryVO> getAllCountries();
}
