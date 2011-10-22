package com.javaid.bolaky.domain.vehicle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;
import com.javaid.bolaky.domain.vehicle.entity.enumerated.VehicleType;

@Entity
@IdClass(VehicleNamePK.class)
@Table(name = "VEHICLE_NAME")
@TypeDefs({
		@TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class),
		@TypeDef(name = "persistence_Local_Date", typeClass = org.joda.time.contrib.hibernate.PersistentLocalDate.class),
		@TypeDef(name = "persistence_Local_Time", typeClass = org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime.class) })
public class VehicleName extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = -4632262479039096693L;

	@Id
	@Column(name = "LANGUAGE_ID")
	private String languageId;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	@Column(name = "VEHICLE_MAKE")
	private String vehicleMake;

	@Column(name = "VEHICLE_MODEL")
	private String vehicleModel;

	@Column(name = "VEHICLE_TYPE")
	private VehicleType vehicleType;

	public String getLanguageId() {
		return languageId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

}
