package com.javaid.bolaky.domain.pools.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.javaid.bolaky.domain.pools.hibernate.group.MandatoryDataRules;

@Embeddable
public class VehicleInfo {

	@NotNull(message = "P70", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "VEHICLE_OWNER_INDICATOR")
	private Boolean vehicleOwner;

	@NotNull(message = "P80", groups = MandatoryDataRules.class)
	@Column(name = "VEHICLE_SEATS_NUMBER")
	private Integer vehicleSeatsNumber;

	@NotNull(message = "P90", groups = MandatoryDataRules.class)
	@Column(name = "VEHICLE_MAKE_CODE")
	private String vehicleMakeCode;

	@NotNull(message = "P100", groups = MandatoryDataRules.class)
	@Column(name = "VEHICLE_MODEL_CODE")
	private String vehicleModelCode;

	@NotNull(message = "P110", groups = MandatoryDataRules.class)
	@Column(name = "VEHICLE_TYPE_CODE")
	private String vehicleTypeCode;

	public Boolean getVehicleOwner() {
		return vehicleOwner;
	}

	public String getVehicleMakeCode() {
		return vehicleMakeCode;
	}

	public String getVehicleModelCode() {
		return vehicleModelCode;
	}

	public String getVehicleTypeCode() {
		return vehicleTypeCode;
	}

	public Integer getVehicleSeatsNumber() {
		return vehicleSeatsNumber;
	}

	public void setVehicleOwner(Boolean vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public void setVehicleMakeCode(String vehicleMakeCode) {
		this.vehicleMakeCode = vehicleMakeCode;
	}

	public void setVehicleModelCode(String vehicleModelCode) {
		this.vehicleModelCode = vehicleModelCode;
	}

	public void setVehicleTypeCode(String vehicleTypeCode) {
		this.vehicleTypeCode = vehicleTypeCode;
	}

	public void setVehicleSeatsNumber(Integer vehicleSeatsNumber) {
		this.vehicleSeatsNumber = vehicleSeatsNumber;
	}

}
