package com.javaid.bolaky.domain.pools.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import com.javaid.bolaky.domain.pools.hibernate.group.MandatoryDataRules;

@Embeddable
public class DestinationInfo {

	@NotNull(message = "P170", groups = MandatoryDataRules.class)
	@Future(message = "P171", groups = MandatoryDataRules.class)
	@Column(name = "END_DATE_UTC")
	@Type(type = "persistence_Local_Date")
	private LocalDate endDate;

	@NotNull(message = "P180", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P180", groups = MandatoryDataRules.class)
	@Column(name = "TO_AREA_CODE")
	private String toAreaCode;

	@NotNull(message = "P190", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P190", groups = MandatoryDataRules.class)
	@Column(name = "TO_DISTRICT_CODE")
	private String toDistictCode;

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getToAreaCode() {
		return toAreaCode;
	}

	public String getToDistictCode() {
		return toDistictCode;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setToAreaCode(String toAreaCode) {
		this.toAreaCode = toAreaCode;
	}

	public void setToDistictCode(String toDistictCode) {
		this.toDistictCode = toDistictCode;
	}

}
