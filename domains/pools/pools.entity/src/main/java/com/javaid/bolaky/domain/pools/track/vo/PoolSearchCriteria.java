package com.javaid.bolaky.domain.pools.track.vo;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

import com.javaid.bolaky.domain.pools.entity.enumerated.AgeGroup;
import com.javaid.bolaky.domain.pools.entity.enumerated.DayOfWeek;
import com.javaid.bolaky.domain.pools.entity.enumerated.Gender;

public class PoolSearchCriteria {

	private Gender driverGender;

	private Boolean shareCost;

	private AgeGroup driverAgeGroup;

	private Integer numberOfCurrentPassengers;

	private Boolean oneWayReturn;

	private StartingPointInfoPoolSearchCriteria startingPointInfoPoolSearchCriteria = new StartingPointInfoPoolSearchCriteria();

	private DestinationInfoPoolSearchCriteria destinationInfoPoolSearchCriteria = new DestinationInfoPoolSearchCriteria();

	private Set<DayOfWeek> poolDays = new ListOrderedSet<DayOfWeek>();

	public Gender getDriverGender() {
		return driverGender;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public AgeGroup getDriverAgeGroup() {
		return driverAgeGroup;
	}

	public Integer getNumberOfCurrentPassengers() {
		return numberOfCurrentPassengers;
	}

	public Boolean getOneWayReturn() {
		return oneWayReturn;
	}

	public StartingPointInfoPoolSearchCriteria getStartingPointInfoPoolSearchCriteria() {
		return startingPointInfoPoolSearchCriteria;
	}

	public DestinationInfoPoolSearchCriteria getDestinationInfoPoolSearchCriteria() {
		return destinationInfoPoolSearchCriteria;
	}

	public Set<DayOfWeek> getPoolDays() {
		return poolDays;
	}

	public void setDriverGender(Gender driverGender) {
		this.driverGender = driverGender;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setDriverAgeGroup(AgeGroup driverAgeGroup) {
		this.driverAgeGroup = driverAgeGroup;
	}

	public void setNumberOfCurrentPassengers(Integer numberOfCurrentPassengers) {
		this.numberOfCurrentPassengers = numberOfCurrentPassengers;
	}

	public void setOneWayReturn(Boolean oneWayReturn) {
		this.oneWayReturn = oneWayReturn;
	}
	
	public void addDayOfWeek(DayOfWeek dayOfWeek){
		
		this.poolDays.add(dayOfWeek);
	}

}
