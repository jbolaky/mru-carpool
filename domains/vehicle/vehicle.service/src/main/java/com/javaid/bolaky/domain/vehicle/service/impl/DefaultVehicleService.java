package com.javaid.bolaky.domain.vehicle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaid.bolaky.domain.vehicle.entity.Vehicle;
import com.javaid.bolaky.domain.vehicle.repository.api.VehicleRepository;
import com.javaid.bolaky.domain.vehicle.service.api.VehicleService;

public class DefaultVehicleService implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle saveVehicle(Vehicle vehicle) {

		return vehicleRepository.save(vehicle);
	}

	public Vehicle findVehicle(Long vehicleId) {

		return vehicleRepository.findOne(vehicleId);
	}

}
