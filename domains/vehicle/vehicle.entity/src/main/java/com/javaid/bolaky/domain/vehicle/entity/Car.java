package com.javaid.bolaky.domain.vehicle.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

	private static final long serialVersionUID = -8201340406255939518L;

	public Car() {
		super.setNumberOfWheels(4);
	}

}