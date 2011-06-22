package com.javaid.bolaky.carpool.service.acl.location.impl;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.carpool.service.vo.CountryVO;
import com.javaid.bolaky.domain.location.entity.Country;

public class LocationAclTranslator {

	public static Set<CountryVO> mapCountryVOs(Set<Country> countries) {

		Set<CountryVO> countryVOs = new ListOrderedSet<CountryVO>();

		if (countries != null && !countries.isEmpty()) {

			for (Country country : countries) {
				CountryVO countryVO = new CountryVO();
				countryVO.setCountryId(country.getCountryId());
				countryVO.setCountryName(country.getCountryName());

				countryVOs.add(countryVO);
			}
		}

		return countryVOs;
	}
}
