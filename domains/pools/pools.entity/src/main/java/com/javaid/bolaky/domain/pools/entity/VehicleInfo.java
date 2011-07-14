package com.javaid.bolaky.domain.pools.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.javaid.bolaky.domain.pools.hibernate.group.MandatoryDataRules;

@Embeddable
public class VehicleInfo {

	@NotNull(message = "P70", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "OWNER_INDICATOR")
	private Boolean owner;

	@NotNull(message = "P80", groups = MandatoryDataRules.class)
	@Column(name = "MAX_SEATS")
	private Integer maxNumberOfSeats;

	@NotNull(message = "P90", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P90", groups = MandatoryDataRules.class)
	@Column(name = "MAKE_CODE")
	private String makeCode;

	@NotNull(message = "P100", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P100", groups = MandatoryDataRules.class)
	@Column(name = "MODEL_CODE")
	private String modelCode;

	@NotNull(message = "P110", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P110", groups = MandatoryDataRules.class)
	@Column(name = "TYPE_CODE")
	private String typeCode;

	public Boolean isOwner() {
		return owner;
	}

	public Integer getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public String getMakeCode() {
		return makeCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public void setMaxNumberOfSeats(Integer maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}

	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
