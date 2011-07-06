package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

public class LocationVO implements Serializable {

	private static final long serialVersionUID = -7094738648770419184L;

	private Long countryId;
	private String countryName;

	private Long areaId;
	private String areaName;

	private Long districtId;
	private String districtName;

	public LocationVO() {
		super();
	}

	public LocationVO(Long countryId, String countryName, Long areaId,
			String areaName, Long districtId, String districtName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.areaId = areaId;
		this.areaName = areaName;
		this.districtId = districtId;
		this.districtName = districtName;
	}

	public Long getAreaId() {
		return areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
