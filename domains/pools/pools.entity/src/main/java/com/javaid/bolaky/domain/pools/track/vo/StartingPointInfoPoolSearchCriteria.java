package com.javaid.bolaky.domain.pools.track.vo;

public class StartingPointInfoPoolSearchCriteria {

	private String fromAreaCode;

	private String fromDistrictCode;
	
	public StartingPointInfoPoolSearchCriteria() {
		super();
	}

	public StartingPointInfoPoolSearchCriteria(String fromAreaCode,
			String fromDistrictCode) {
		super();
		this.fromAreaCode = fromAreaCode;
		this.fromDistrictCode = fromDistrictCode;
	}

	public String getFromAreaCode() {
		return fromAreaCode;
	}

	public String getFromDistrictCode() {
		return fromDistrictCode;
	}

	public void setFromAreaCode(String fromAreaCode) {
		this.fromAreaCode = fromAreaCode;
	}

	public void setFromDistrictCode(String fromDistrictCode) {
		this.fromDistrictCode = fromDistrictCode;
	}

}
