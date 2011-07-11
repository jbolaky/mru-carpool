package com.javaid.bolaky.carpool.service.acl.pools.impl;

import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.domain.pools.entity.Pool;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;

public class PoolsAclTranslator {

	public static Pool convertPool(CarPoolRegistrationVO carPoolRegistrationVO){
		
		Pool pool = null;
		
		if(carPoolRegistrationVO!=null){
			
			pool = new Pool();
			
			pool.setUsername(carPoolRegistrationVO.getUsername());
			
			//FIXME
			pool.setPoolType(null);
			pool.setValidLicense(carPoolRegistrationVO.getValidLicense());
			pool.setSmoker(carPoolRegistrationVO.getSmoker());
			pool.setOneWayTravel(carPoolRegistrationVO.getOneWayTravel());
			pool.setNumberOfCurrentPassengers(carPoolRegistrationVO.getNumberOfCurrentPassengers());
			pool.setPrefferedGenderToTravelWith(Gender.convertCode(carPoolRegistrationVO.getGenderToTravelWith()));
			pool.setUserPoolAdditionalDetails(carPoolRegistrationVO.getAdditionalDetails());
		/*	pool.setPoolStatus(poolStatus);
			pool.getVehicleInfo().setVehicleOwner(vehicleOwner);
			pool.getVehicleInfo().setVehicleMakeCode(vehicleMakeCode);
			pool.getVehicleInfo().setVehicleModelCode(vehicleModelCode);
			pool.getVehicleInfo().setVehicleTypeCode(vehicleTypeCode);
			pool.getStartingPointInfo().setStartingDate(startingDate);
			pool.getStartingPointInfo().setDepartureTime(departureTime);
			pool.getStartingPointInfo().setFromAreaCode(fromAreaCode);
			pool.getStartingPointInfo().setFromDistrictCode(fromDistrictCode);
			pool.getDestinationInfo().setEndDate(endDate);
			pool.getDestinationInfo().setToAreaCode(toAreaCode);
			pool.getDestinationInfo().setToDistictCode(toDistictCode);*/
		
		}
		
		return pool;
	}
}
