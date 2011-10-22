package com.javaid.bolaky.domain.vehicle.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.vehicle.entity.enumerated.VehicleType;
import com.javaid.bolaky.domain.vehicle.repository.api.VehicleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/vehicle-entity-default-context.xml",
		"classpath:/default-vehicle-datasource-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleRepositoryIntegrationTests {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Before
	public void populateUsername() {
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				"Javaid", "Jav");
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@Test
	public void testSaveVehicle() {

		Car car = new Car();
		car.setNumberOfDoors(2);
		car.setNumberOfSeats(4);

		VehicleName vehicleNameHondaJazzGB = new VehicleName();
		vehicleNameHondaJazzGB.setLanguageId("EN");
		vehicleNameHondaJazzGB.setVehicleMake("Honda");
		vehicleNameHondaJazzGB.setVehicleModel("Jazz");
		vehicleNameHondaJazzGB.setVehicleType(VehicleType.HATCHBACK);

		VehicleName vehicleNameHondaJazzFR = new VehicleName();
		vehicleNameHondaJazzFR.setLanguageId("FR");
		vehicleNameHondaJazzFR.setVehicleMake("Honda");
		vehicleNameHondaJazzFR.setVehicleModel("Jazz");
		vehicleNameHondaJazzFR.setVehicleType(VehicleType.HATCHBACK);

		car.addVehicleName(vehicleNameHondaJazzGB);
		car.addVehicleName(vehicleNameHondaJazzFR);

		vehicleRepository.save(car);

		car = (Car) vehicleRepository.findOne(car.getVehicleId());

		assertThat(car, is(notNullValue()));
		assertThat(car.getVehicleNames(), is(notNullValue()));
		assertThat(car.getVehicleNames().size(), is(2));

		Iterator<VehicleName> iteratorVehicleName = car.getVehicleNames()
				.iterator();

		VehicleName vehicleName = iteratorVehicleName.next();
		assertThat(vehicleName.getVehicleMake(), is("Honda"));

		vehicleName = iteratorVehicleName.next();
		assertThat(vehicleName.getVehicleMake(), is("Honda"));
	}
}
