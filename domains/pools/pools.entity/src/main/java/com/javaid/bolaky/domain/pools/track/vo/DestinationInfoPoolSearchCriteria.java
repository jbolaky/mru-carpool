package com.javaid.bolaky.domain.pools.track.vo;

public class DestinationInfoPoolSearchCriteria {

	private String toAreaCode;

	private String toDistictCode;

	public DestinationInfoPoolSearchCriteria() {
		super();
	}

	public DestinationInfoPoolSearchCriteria(String toAreaCode,
			String toDistictCode) {
		super();
		this.toAreaCode = toAreaCode;
		this.toDistictCode = toDistictCode;
	}

	public String getToAreaCode() {
		return toAreaCode;
	}

	public String getToDistictCode() {
		return toDistictCode;
	}

	public void setToAreaCode(String toAreaCode) {
		this.toAreaCode = toAreaCode;
	}

	public void setToDistictCode(String toDistictCode) {
		this.toDistictCode = toDistictCode;
	}

}
