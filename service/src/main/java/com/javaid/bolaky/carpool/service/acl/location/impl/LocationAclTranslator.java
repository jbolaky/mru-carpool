package com.javaid.bolaky.carpool.service.acl.location.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.domain.location.entity.Country;

public class LocationAclTranslator {

	public static Set<LocationVO> mapCountryVOs(Set<Country> countries) {

		Set<LocationVO> countryVOs = new ListOrderedSet<LocationVO>();

		if (countries != null && !countries.isEmpty()) {

			for (Country country : countries) {
				LocationVO countryVO = new LocationVO();
				countryVO.setCountryId(country.getCountryId());
				countryVO.setCountryName(country.getCountryName());

				countryVOs.add(countryVO);
			}
		}

		return countryVOs;
	}
}
