package com.javaid.bolaky.carpool.service.acl.location.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.domain.location.entity.Area;
import com.javaid.bolaky.domain.location.entity.Country;
import com.javaid.bolaky.domain.location.entity.District;

public class LocationAclTranslator {

	public static Set<LocationVO> mapCountries(Set<Country> countries) {

		Set<LocationVO> locationVOs = new ListOrderedSet<LocationVO>();

		if (countries != null && !countries.isEmpty()) {

			for (Country country : countries) {

				locationVOs.add(new LocationVO(country.getCountryId(), country
						.getCountryName(), null, null, null, null));
			}
		}

		return locationVOs;
	}

	public static Set<LocationVO> mapAreas(Set<Area> areas) {

		Set<LocationVO> locationVOs = new ListOrderedSet<LocationVO>();

		if (areas != null && !areas.isEmpty()) {

			for (Area area : areas) {

				locationVOs.add(new LocationVO(null, null, area.getAreaId(),
						area.getAreaName(), null, null));
			}
		}

		return locationVOs;
	}

	public static Set<LocationVO> mapDistricts(Set<District> districts) {

		Set<LocationVO> locationVOs = new ListOrderedSet<LocationVO>();

		if (districts != null && !districts.isEmpty()) {

			for (District district : districts) {

				locationVOs.add(new LocationVO(null, null, null, null, district
						.getDistrictId(), district.getDistrictName()));
			}
		}

		return locationVOs;
	}
}
