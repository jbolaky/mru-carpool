package com.javaid.bolaky.domain.pools.entity;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceException;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.map.ListOrderedMap;
import org.apache.commons.collections15.set.ListOrderedSet;
import org.apache.commons.collections15.set.UnmodifiableSet;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.NotEmpty;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;
import com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolStatus;
import com.javaid.bolaky.domain.pools.entity.enumerated.PoolType;
import com.javaid.bolaky.domain.pools.enumerated.PoolsError;
import com.javaid.bolaky.domain.pools.hibernate.constraint.NumberOfPassengersCheck;
import com.javaid.bolaky.domain.pools.hibernate.constraint.PoolEndDate;
import com.javaid.bolaky.domain.pools.hibernate.constraint.SeatAvailability;
import com.javaid.bolaky.domain.pools.hibernate.group.MandatoryDataRules;

@Entity
@Table(name = "POOL")
@TypeDefs({
		@TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class),
		@TypeDef(name = "persistence_Local_Date", typeClass = org.joda.time.contrib.hibernate.PersistentLocalDate.class),
		@TypeDef(name = "persistence_Local_Time", typeClass = org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime.class),
		@TypeDef(name = "pool_gender_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.pools.entity.enumerated.Gender")),
		@TypeDef(name = "pool_status_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.pools.entity.enumerated.PoolStatus")),
		@TypeDef(name = "pool_age_group_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup")),
		@TypeDef(name = "pool_user_types", typeClass = com.javaid.bolaky.domain.hibernate.jpa.enumeration.GenericEnumUserType.class, parameters = @Parameter(name = "type", value = "com.javaid.bolaky.domain.pools.entity.enumerated.PoolType")) })
@SeatAvailability(groups = MandatoryDataRules.class)
@PoolEndDate(groups = MandatoryDataRules.class)
@NumberOfPassengersCheck(groups = MandatoryDataRules.class)
public class Pool extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 9210101505830391192L;

	@Id
	@Column(name = "POOL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long poolId;

	@NotNull(message = "P10", groups = MandatoryDataRules.class)
	@Column(name = "USERNAME")
	private String username;

	@NotNull(message = "P11", groups = MandatoryDataRules.class)
	@NotEmpty(message = "P11", groups = MandatoryDataRules.class)
	@Column(name = "POOL_NAME")
	private String poolName;

	@NotNull(message = "P12", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "SHARE_COST")
	private Boolean shareCost;

	@NotNull(message = "P20", groups = MandatoryDataRules.class)
	@Column(name = "POOL_TYPE")
	@Type(type = "pool_user_types")
	private PoolType poolType;

	@NotNull(message = "P30", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "VALID_LICENSE_INDICATOR")
	private Boolean validLicense;

	@NotNull(message = "P40", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "SMOKER_INDICATOR")
	private Boolean smoker;

	@NotNull(message = "P50", groups = MandatoryDataRules.class)
	@Type(type = "yes_no")
	@Column(name = "ONE_WAY_TRAVEL_INDICATOR")
	private Boolean oneWayTravel;

	@Column(name = "NUMBER_OF_CURRENT_PASSENGER")
	private Integer numberOfCurrentPassengers = 0;

	@NotNull(message = "P60", groups = MandatoryDataRules.class)
	@Type(type = "pool_gender_user_types")
	@Column(name = "PREFFERED_GENDER_TO_TRAVEL_WITH")
	private Gender prefferedGenderToTravelWith;

	@NotNull(message = "P61", groups = MandatoryDataRules.class)
	@Type(type = "pool_gender_user_types")
	@Column(name = "GENDER")
	private Gender gender;

	@NotNull(message = "P63", groups = MandatoryDataRules.class)
	@Type(type = "pool_age_group_user_types")
	@Column(name = "AGE_GROUP")
	private AgeGroup ageGroup;

	@Column(name = "USER_POOL_ADDITIONAL_DETAILS")
	private String userPoolAdditionalDetails;

	@Type(type = "pool_status_user_types")
	@Column(name = "POOL_STATUS_INDICATOR")
	private PoolStatus poolStatus = PoolStatus.DRAFT;

	@ElementCollection
	@Column(name = "AVAILABLE_SEATS")
	@MapKeyColumn(name = "DAY_OF_WEEK")
	@MapKeyEnumerated(EnumType.STRING)
	@CollectionTable(name = "SEATS_TRAVEL_DAYS", joinColumns = { @JoinColumn(name = "POOL_ID") })
	private Map<DayOfWeek, Integer> travelDaysAndAvailableSeats = new ListOrderedMap<DayOfWeek, Integer>();

	@Valid
	@Embedded
	private VehicleInfo vehicleInfo = new VehicleInfo();

	@Valid
	@Embedded
	private StartingPointInfo startingPointInfo = new StartingPointInfo();;

	@Valid
	@Embedded
	private DestinationInfo destinationInfo = new DestinationInfo();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
	private Set<Passenger> passengers = new ListOrderedSet<Passenger>();

	public Pool() {
		super();
	}

	public Long getPoolId() {
		return poolId;
	}

	public String getPoolName() {
		return poolName;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public Gender getGender() {
		return gender;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public String getUsername() {
		return username;
	}

	public PoolType getPoolType() {
		return poolType;
	}

	public Boolean getValidLicense() {
		return validLicense;
	}

	public Boolean getSmoker() {
		return smoker;
	}

	public Boolean getOneWayTravel() {
		return oneWayTravel;
	}

	public Integer getNumberOfCurrentPassengers() {
		return numberOfCurrentPassengers;
	}

	public Gender getPrefferedGenderToTravelWith() {
		return prefferedGenderToTravelWith;
	}

	public String getUserPoolAdditionalDetails() {
		return userPoolAdditionalDetails;
	}

	public PoolStatus getPoolStatus() {
		return poolStatus;
	}

	public Map<DayOfWeek, Integer> getTravelDaysAndAvailableSeats() {
		return travelDaysAndAvailableSeats;
	}

	public Integer getAvailableSeatsForADay(DayOfWeek dayOfWeek) {

		if (travelDaysAndAvailableSeats.containsKey(dayOfWeek)) {

			for (Entry<DayOfWeek, Integer> entry : travelDaysAndAvailableSeats
					.entrySet()) {

				if (entry.getKey().equals(dayOfWeek)) {
					return entry.getValue();
				}
			}
		}

		return null;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public StartingPointInfo getStartingPointInfo() {
		return startingPointInfo;
	}

	public DestinationInfo getDestinationInfo() {
		return destinationInfo;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public void setPoolType(PoolType poolType) {
		this.poolType = poolType;
	}

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}

	public void setOneWayTravel(Boolean oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setNumberOfCurrentPassengers(Integer numberOfCurrentPassengers) {
		this.numberOfCurrentPassengers = numberOfCurrentPassengers;
	}

	protected void setPoolStatus(PoolStatus poolStatus) {
		this.poolStatus = poolStatus;
	}

	public void setPrefferedGenderToTravelWith(
			Gender prefferedGenderToTravelWith) {
		this.prefferedGenderToTravelWith = prefferedGenderToTravelWith;
	}

	public void setUserPoolAdditionalDetails(String userPoolAdditionalDetails) {
		this.userPoolAdditionalDetails = userPoolAdditionalDetails;
	}

	public void addAvailableSeatsForADay(DayOfWeek dayOfWeek,
			Integer availableSeats) {

		if (travelDaysAndAvailableSeats.containsKey(dayOfWeek)) {
			travelDaysAndAvailableSeats.remove(dayOfWeek);
		}
		travelDaysAndAvailableSeats.put(dayOfWeek, availableSeats);
	}

	public void addAdditionalSeatsForADay(DayOfWeek dayOfWeek,
			Integer availableSeatsToAdd) {

		if (travelDaysAndAvailableSeats.containsKey(dayOfWeek)) {
			Set<Entry<DayOfWeek, Integer>> entries = travelDaysAndAvailableSeats
					.entrySet();
			Iterator<Entry<DayOfWeek, Integer>> iterator = entries.iterator();

			while (iterator.hasNext()) {

				Entry<DayOfWeek, Integer> entry = iterator.next();

				if (entry.getKey().equals(dayOfWeek)) {
					entry.setValue(entry.getValue() + availableSeatsToAdd);
				}

				break;
			}
		}
	}

	public void addPassengers(Passenger passenger) {

		if (passenger != null) {
			passenger.setPool(this);
		}

		this.passengers.add(passenger);
	}

	private Set<PoolsError> validate() {

		Set<PoolsError> poolsErrors = new ListOrderedSet<PoolsError>();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Pool>> constraintViolations = validator
				.validate(this, MandatoryDataRules.class);

		for (ConstraintViolation<Pool> constraintViolation : constraintViolations) {

			poolsErrors.add(PoolsError.getPoolsError(constraintViolation
					.getMessage()));
		}

		return UnmodifiableSet.decorate(poolsErrors);
	}

	public Set<PoolsError> activate() {

		Set<PoolsError> poolsErrors = null;

		if (this.poolStatus.equals(PoolStatus.ACTIVE)
				|| this.poolStatus.equals(PoolStatus.DRAFT)
				|| this.poolStatus.equals(PoolStatus.CANCELLED)) {

			poolsErrors = this.validate();

			if (poolsErrors != null && poolsErrors.isEmpty()) {
				this.poolStatus = PoolStatus.ACTIVE;
			}
		}

		return poolsErrors;
	}

	public void cancelled() {

		if (this.poolStatus.equals(PoolStatus.ACTIVE)
				|| this.poolStatus.equals(PoolStatus.DRAFT)
				|| this.poolStatus.equals(PoolStatus.CANCELLED)) {

			this.poolStatus = PoolStatus.CANCELLED;
		}
	}

	public void completed() {

		if (this.poolStatus.equals(PoolStatus.DRAFT)
				|| this.poolStatus.equals(PoolStatus.ACTIVE)) {

			final Set<PoolsError> poolsErrors = this.validate();
			final String startingDateFutureErrorCode = "P120";
			final String endDateFutureErrorCode = "P171";

			Predicate<PoolsError> startingDateErrorCodePredicate = new Predicate<PoolsError>() {

				public boolean evaluate(PoolsError poolsError) {
					return poolsError.getErrorCode().equalsIgnoreCase(
							startingDateFutureErrorCode);
				}
			};

			Predicate<PoolsError> endDateErrorCodePredicate = new Predicate<PoolsError>() {

				public boolean evaluate(PoolsError poolsError) {
					return poolsError.getErrorCode().equalsIgnoreCase(
							endDateFutureErrorCode);
				}
			};

			if (CollectionUtils.exists(poolsErrors,
					startingDateErrorCodePredicate)
					&& CollectionUtils.exists(poolsErrors,
							endDateErrorCodePredicate)) {

				this.poolStatus = PoolStatus.COMPLETED;
			}
		}
	}

	@PrePersist
	public void checkPoolState() {

		if (this.poolStatus.equals(PoolStatus.DRAFT)) {
			throw new PersistenceException(
					"cannot persist a pool in a draft state");
		}
	}
}
