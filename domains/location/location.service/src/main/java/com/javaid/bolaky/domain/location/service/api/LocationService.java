package com.javaid.bolaky.domain.location.service.api;

import java.util.Set;

import com.javaid.bolaky.domain.location.entity.Area;
import com.javaid.bolaky.domain.location.entity.Country;

public interface LocationService {

	Set<Country> findCountries();

	Country findCountry(Long countryId);

	Area findArea(Long areaId);
}
