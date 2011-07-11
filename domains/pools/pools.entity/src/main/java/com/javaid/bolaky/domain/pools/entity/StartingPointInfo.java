package com.javaid.bolaky.domain.pools.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.javaid.bolaky.domain.pools.hibernate.group.MandatoryDataRules;

@Embeddable
public class StartingPointInfo {

	@Future(message = "P120", groups = MandatoryDataRules.class)
	@NotNull(message = "P130", groups = MandatoryDataRules.class)
	@Column(name = "STARTING_DATE_UTC")
	@Type(type = "persistence_Local_Date")
	private LocalDate startingDate;

	@NotNull(message = "P140", groups = MandatoryDataRules.class)
	@Column(name = "DEPATURE_TIME_UTC")
	@Type(type = "persistence_Local_Time")
	private LocalTime departureTime;

	@NotNull(message = "P150", groups = MandatoryDataRules.class)
	@Column(name = "FROM_AREA_CODE")
	private String fromAreaCode;

	@NotNull(message = "P160", groups = MandatoryDataRules.class)
	@Column(name = "FROM_DISTRICT_CODE")
	private String fromDistrictCode;

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public String getFromAreaCode() {
		return fromAreaCode;
	}

	public String getFromDistrictCode() {
		return fromDistrictCode;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setFromAreaCode(String fromAreaCode) {
		this.fromAreaCode = fromAreaCode;
	}

	public void setFromDistrictCode(String fromDistrictCode) {
		this.fromDistrictCode = fromDistrictCode;
	}

}
