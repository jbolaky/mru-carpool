package com.javaid.bolaky.domain.pools.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolStatus;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolType;
import com.javaid.bolaky.domain.pools.entity.enumerated.StateStatus;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;
import com.javaid.bolaky.domain.pools.repository.api.PoolsRepository;
import com.javaid.bolaky.domain.pools.track.vo.PoolSearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/default-pools-entity-context.xml",
		"classpath:/default-pools-datasource-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional(propagation = Propagation.REQUIRED)
public class PoolsRepositoryIntegrationTests {

	@Autowired
	private PoolsRepository poolsRepository;

	@Before
	public void populateUsername() {
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				"Javaid", "Jav");
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@Test(expected = JpaSystemException.class)
	public void testSavingAPoolInDraftState() {

		String username1 = Long.toString(RandomUtils.nextLong());
		String username2 = Long.toString(RandomUtils.nextLong());
		String username3 = Long.toString(RandomUtils.nextLong());
		String username4 = Long.toString(RandomUtils.nextLong());

		Pool pool = createPool(AgeGroup.EIGHTTEEN_TO_TWENTY, true, "poolname",
				Gender.FEMALE, username1, PoolType.CARPOOL, true, true, true,
				2, 2, Gender.FEMALE, "No additional details", true, "A", "B",
				"C", new LocalDate(), new LocalTime(), "A", "B",
				new LocalDate(), "A", "B");

		pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY, 1);
		pool.addAvailableSeatsForADay(DayOfWeek.MONDAY, 2);
		pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY, 3);
		pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY, 5);
		pool.addAdditionalSeatsForADay(DayOfWeek.SUNDAY, 2);

		Passenger passenger1 = createPassenger(username2, StateStatus.ACCEPTED);
		Passenger passenger2 = createPassenger(username3, StateStatus.PENDING);
		Passenger passenger3 = createPassenger(username4, StateStatus.REJECTED);

		pool.addPassengers(passenger1);
		pool.addPassengers(passenger2);
		pool.addPassengers(passenger3);

		pool = poolsRepository.save(pool);
	}

	@Test
	public void testSaveAndFindOneInActiveState() {

		String username1 = Long.toString(RandomUtils.nextLong());
		String username2 = Long.toString(RandomUtils.nextLong());
		String username3 = Long.toString(RandomUtils.nextLong());
		String username4 = Long.toString(RandomUtils.nextLong());

		Pool pool = createPool(AgeGroup.EIGHTTEEN_TO_TWENTY, true, "poolname",
				Gender.FEMALE, username1, PoolType.CARPOOL, true, true, true,
				2, 12, Gender.FEMALE, "No additional details", true, "A", "B",
				"C", new LocalDate().plusDays(1), new LocalTime(), "A", "B",
				new LocalDate().plusDays(1), "A", "B");

		pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY, 1);
		pool.addAvailableSeatsForADay(DayOfWeek.MONDAY, 2);
		pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY, 3);
		pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY, 5);
		pool.addAdditionalSeatsForADay(DayOfWeek.SUNDAY, 2);

		Passenger passenger1 = createPassenger(username2, StateStatus.ACCEPTED);
		Passenger passenger2 = createPassenger(username3, StateStatus.PENDING);
		Passenger passenger3 = createPassenger(username4, StateStatus.REJECTED);

		pool.addPassengers(passenger1);
		pool.addPassengers(passenger2);
		pool.addPassengers(passenger3);

		Set<PoolsError> poolsErrors = pool.activate();

		assertThat(poolsErrors, is(notNullValue()));
		assertTrue(poolsErrors.isEmpty());
		assertThat(pool.getPoolStatus(), is(PoolStatus.ACTIVE));

		pool = poolsRepository.save(pool);
		assertThat(pool.getCreationUsername(), is("Javaid"));

		Pool pool2 = poolsRepository.findOne(pool.getPoolId());
		assertThat(pool.getOneWayTravel(), is(pool2.getOneWayTravel()));
		assertThat(pool.getPassengers().size(), is(3));
		assertThat(pool.getAvailableSeatsForADay(DayOfWeek.SUNDAY), is(3));
	}

	@Test
	public void testSaveAndFindOneInCompletedState() {

		String username1 = Long.toString(RandomUtils.nextLong());
		String username2 = Long.toString(RandomUtils.nextLong());
		String username3 = Long.toString(RandomUtils.nextLong());
		String username4 = Long.toString(RandomUtils.nextLong());

		Pool pool = createPool(AgeGroup.EIGHTTEEN_TO_TWENTY, true, "poolname",
				Gender.FEMALE, username1, PoolType.CARPOOL, true, true, true,
				2, 2, Gender.FEMALE, "No additional details", true, "A", "B",
				"C", new LocalDate().minusDays(4), new LocalTime(), "A", "B",
				new LocalDate().minusDays(1), "A", "B");

		pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY, 1);
		pool.addAvailableSeatsForADay(DayOfWeek.MONDAY, 2);
		pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY, 3);
		pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY, 5);
		pool.addAdditionalSeatsForADay(DayOfWeek.SUNDAY, 2);

		Passenger passenger1 = createPassenger(username2, StateStatus.ACCEPTED);
		Passenger passenger2 = createPassenger(username3, StateStatus.PENDING);
		Passenger passenger3 = createPassenger(username4, StateStatus.REJECTED);

		pool.addPassengers(passenger1);
		pool.addPassengers(passenger2);
		pool.addPassengers(passenger3);

		pool.completed();
		assertThat(pool.getPoolStatus(), is(PoolStatus.COMPLETED));

		pool = poolsRepository.save(pool);
		assertThat(pool.getCreationUsername(), is("Javaid"));

		Pool pool2 = poolsRepository.findOne(pool.getPoolId());
		assertThat(pool.getOneWayTravel(), is(pool2.getOneWayTravel()));
		assertThat(pool.getPassengers().size(), is(3));
		assertThat(pool.getAvailableSeatsForADay(DayOfWeek.SUNDAY), is(3));
	}

	@Test
	public void testSaveAndFindOneInCancelledState() {

		String username1 = Long.toString(RandomUtils.nextLong());
		String username2 = Long.toString(RandomUtils.nextLong());
		String username3 = Long.toString(RandomUtils.nextLong());
		String username4 = Long.toString(RandomUtils.nextLong());

		Pool pool = createPool(AgeGroup.EIGHTTEEN_TO_TWENTY, true, "poolname",
				Gender.FEMALE, username1, PoolType.CARPOOL, true, true, true,
				2, 2, Gender.FEMALE, "No additional details", true, "A", "B",
				"C", new LocalDate().plusDays(1), new LocalTime(), "A", "B",
				new LocalDate().plusDays(1), "A", "B");

		pool.addAvailableSeatsForADay(DayOfWeek.SUNDAY, 1);
		pool.addAvailableSeatsForADay(DayOfWeek.MONDAY, 2);
		pool.addAvailableSeatsForADay(DayOfWeek.WEDNESDAY, 3);
		pool.addAvailableSeatsForADay(DayOfWeek.FRIDAY, 5);
		pool.addAdditionalSeatsForADay(DayOfWeek.SUNDAY, 2);

		Passenger passenger1 = createPassenger(username2, StateStatus.ACCEPTED);
		Passenger passenger2 = createPassenger(username3, StateStatus.PENDING);
		Passenger passenger3 = createPassenger(username4, StateStatus.REJECTED);

		pool.addPassengers(passenger1);
		pool.addPassengers(passenger2);
		pool.addPassengers(passenger3);

		pool.cancelled();
		assertThat(pool.getPoolStatus(), is(PoolStatus.CANCELLED));

		pool = poolsRepository.save(pool);
		assertThat(pool.getCreationUsername(), is("Javaid"));

		Pool pool2 = poolsRepository.findOne(pool.getPoolId());
		assertThat(pool.getOneWayTravel(), is(pool2.getOneWayTravel()));
		assertThat(pool.getPassengers().size(), is(3));
		assertThat(pool.getAvailableSeatsForADay(DayOfWeek.SUNDAY), is(3));
	}

	@Test
	public void testFindPool() {

		PoolSearchCriteria poolSearchCriteria = new PoolSearchCriteria();
		poolSearchCriteria.setOneWayReturn(true);

		poolSearchCriteria.addDayOfWeek(DayOfWeek.MONDAY);

		List<Pool> pools = poolsRepository.findPool(poolSearchCriteria);

		assertThat(pools, is(notNullValue()));
		assertTrue(pools.size() > 0);
	}

	private Pool createPool(AgeGroup ageGroup, Boolean shareCost,
			String carPoolName, Gender gender, String username,
			PoolType poolType, Boolean validLicense, Boolean smoker,
			Boolean oneWayTravel, Integer numberOfCurrentPassengers,
			Integer vehicleSeatsNumber, Gender prefferedGenderToTravelWith,
			String userPoolAdditionalDetails, Boolean vehicleOwner,
			String vehicleMakeCode, String vehicleModelCode,
			String vehicleTypeCode, LocalDate startingDate,
			LocalTime departureTime, String fromAreaCode,
			String fromDistrictCode, LocalDate endDate, String toAreaCode,
			String toDistictCode) {

		Pool pool = new Pool();

		pool.setGender(gender);
		pool.setShareCost(shareCost);
		pool.setPoolName(carPoolName);
		pool.setUsername(username);
		pool.setAgeGroup(ageGroup);
		pool.setPoolType(poolType);
		pool.setValidLicense(validLicense);
		pool.setSmoker(smoker);
		pool.setOneWayTravel(oneWayTravel);
		pool.setNumberOfCurrentPassengers(numberOfCurrentPassengers);
		pool.setPrefferedGenderToTravelWith(prefferedGenderToTravelWith);
		pool.setUserPoolAdditionalDetails(userPoolAdditionalDetails);
		pool.getVehicleInfo().setMaxNumberOfSeats(vehicleSeatsNumber);
		pool.getVehicleInfo().setOwner(vehicleOwner);
		pool.getVehicleInfo().setMakeCode(vehicleMakeCode);
		pool.getVehicleInfo().setModelCode(vehicleModelCode);
		pool.getVehicleInfo().setTypeCode(vehicleTypeCode);
		pool.getStartingPointInfo().setStartingDate(startingDate);
		pool.getStartingPointInfo().setDepartureTime(departureTime);
		pool.getStartingPointInfo().setFromAreaCode(fromAreaCode);
		pool.getStartingPointInfo().setFromDistrictCode(fromDistrictCode);
		pool.getDestinationInfo().setEndDate(endDate);
		pool.getDestinationInfo().setToAreaCode(toAreaCode);
		pool.getDestinationInfo().setToDistictCode(toDistictCode);

		return pool;
	}

	private Passenger createPassenger(String username, StateStatus stateStatus) {

		Passenger passenger = new Passenger();
		passenger.setUsername(username);
		passenger.setStateStatus(stateStatus);

		return passenger;
	}
}
