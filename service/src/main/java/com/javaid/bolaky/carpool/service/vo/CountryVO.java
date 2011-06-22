package com.javaid.bolaky.carpool.service.vo;

public class CountryVO {

	private Long countryId;

	private String countryName;
	
	public CountryVO() {
		super();
	}

	public CountryVO(Long countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}

