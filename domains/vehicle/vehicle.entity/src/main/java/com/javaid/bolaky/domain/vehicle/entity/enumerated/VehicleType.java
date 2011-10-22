package com.javaid.bolaky.domain.vehicle.entity.enumerated;

public enum VehicleType {

	SEDAN('S'),HATCHBACK('H');

	private Character code;

	private VehicleType(Character code) {
		this.code = code;
	}

	public Character getCode() {
		return code;
	}

	public static VehicleType convertCode(Character code) {

		if (code != null) {

			for (VehicleType vehicleType : values()) {

				if (code < vehicleType.getCode()) {
					return vehicleType;
				}
			}
		}

		return null;
	}
}
