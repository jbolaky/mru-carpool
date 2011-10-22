package com.javaid.bolaky.domain.vehicle.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;

@Entity
@Table(name = "VEHICLE")
@Inheritance
@DiscriminatorColumn(name = "VEHICLE_TYPE")
@TypeDefs({
		@TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class),
		@TypeDef(name = "persistence_Local_Date", typeClass = org.joda.time.contrib.hibernate.PersistentLocalDate.class),
		@TypeDef(name = "persistence_Local_Time", typeClass = org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime.class) })
public class Vehicle extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 3120475978978516171L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "VEHICLE_ID")
	private Long vehicleId;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Set<VehicleName> vehicleNames = new ListOrderedSet<VehicleName>();

	@Column(name = "NUM_DOORS")
	private Integer numberOfDoors;

	@Column(name = "NUM_SEATS")
	private Integer numberOfSeats;

	@Column(name = "NUM_WHEELS")
	private Integer numberOfWheels;

	public Long getVehicleId() {
		return vehicleId;
	}

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public Integer getNumberOfWheels() {
		return numberOfWheels;
	}

	public Set<VehicleName> getVehicleNames() {
		return vehicleNames;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setNumberOfWheels(Integer numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public void addVehicleName(VehicleName vehicleName) {

		if (vehicleName != null) {

			vehicleName.setVehicle(this);
		}

		vehicleNames.add(vehicleName);
	}
}
