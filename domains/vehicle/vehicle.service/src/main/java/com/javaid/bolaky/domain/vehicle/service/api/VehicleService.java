package com.javaid.bolaky.domain.vehicle.service.api;

import com.javaid.bolaky.domain.vehicle.entity.Vehicle;

public interface VehicleService {

	Vehicle saveVehicle(Vehicle vehicle);
	
	Vehicle findVehicle(Long vehicleId);
}
