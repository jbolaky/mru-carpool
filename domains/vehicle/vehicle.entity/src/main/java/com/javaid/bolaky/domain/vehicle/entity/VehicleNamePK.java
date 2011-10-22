package com.javaid.bolaky.domain.vehicle.entity;

import java.io.Serializable;

public class VehicleNamePK implements Serializable {

	private static final long serialVersionUID = 1549279927840560614L;

	private String languageId;

	private Long vehicle;

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public Long getVehicle() {
		return vehicle;
	}

	public void setVehicle(Long vehicle) {
		this.vehicle = vehicle;
	}

}
