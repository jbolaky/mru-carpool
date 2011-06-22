package com.javaid.bolaky.domain.location.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.location.repository.api.LocationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/default-location-entity-context.xml",
		"classpath:/default-location-datasource-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional(propagation = Propagation.REQUIRED)
public class LocationRepositoryIntegrationTest {

	@Autowired
	private LocationRepository locationRepository;

	@Before
	public void populateUsername() {
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				"Javaid", "Jav");
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testIfAuthenticationCredentialsNotFoundExceptionIsThrownWhenUsernameNotProvided() {

		SecurityContextHolder.getContext().setAuthentication(null);
		Country country = createCountry("France");
		country = locationRepository.save(country);
	}

	@Test
	public void testSaveAndFind() {

		Country country = createCountry("England");

		Area londonArea = createArea("London");
		District londonDistrict = createDistrict("City of London", true);
		District londonDistrict2 = createDistrict("City of Westminster", true);
		District londonDistrict3 = createDistrict("Kingston", true);
		District londonDistrict4 = createDistrict("Greenwich", true);
		londonArea.addDistrict(londonDistrict);
		londonArea.addDistrict(londonDistrict2);
		londonArea.addDistrict(londonDistrict3);
		londonArea.addDistrict(londonDistrict4);
		country.addArea(londonArea);

		Area liverpoolArea = createArea("Liverpool");
		District liverpoolDistrict = createDistrict("LFC", false);
		liverpoolArea.addDistrict(liverpoolDistrict);
		country.addArea(liverpoolArea);

		country = locationRepository.save(country);
		assertThat(country.getCreationUsername(), is("Javaid"));
		assertThat(country.getCountryId(), is(notNullValue()));

		Country country2 = locationRepository.findOne(country.getCountryId());
		assertThat(country2.getCountryName(), is("England"));
		assertThat(country2.getAreas().size(), is(2));

		Iterator<Area> iteratorArea = country2.getAreas().iterator();
		Area area = iteratorArea.next();
		assertThat(area.getAreaName(), is("London"));
		Iterator<District> iteratorDistrict = area.getDistricts().iterator();
		assertThat(iteratorDistrict.next().getDistrictName(),
				is("City of London"));
		assertThat(iteratorDistrict.next().getDistrictName(),
				is("City of Westminster"));
		assertThat(iteratorDistrict.next().getDistrictName(), is("Kingston"));
		assertThat(iteratorDistrict.next().getDistrictName(), is("Greenwich"));

		assertThat(iteratorArea.next().getAreaName(), is("Liverpool"));

	}

	private Country createCountry(String countryName) {

		Country country = new Country();
		country.setCountryName(countryName);

		return country;
	}

	private Area createArea(String areaName) {

		Area area = new Area();
		area.setAreaName(areaName);

		return area;
	}

	private District createDistrict(String districtName, Boolean isCity) {

		District district = new District();
		district.setDistrictName(districtName);
		district.setCity(isCity);

		return district;
	}
}
