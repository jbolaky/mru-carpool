package com.javaid.bolaky.carpool.service.vo;

import org.joda.time.LocalTime;

public class PoolSearchResultVO {

	private Long poolId;
	
	private String driverAdditionalDetails;
	
	private String fromRegionName;
	
	private String fromAreaName;
	
	private String toRegionName;
	
	private String toAreaName;
	
	private LocalTime departureTime;
	
	private LocalTime returnTime;
	
	private Boolean smoker;
	
	private Integer mondayNumberOfBookedPersons;
	
	private Integer tuesdayNumberOfBookedPersons;
	
	private Integer wednesdayNumberOfBookedPersons;
	
	private Integer thursdayNumberOfBookedPersons;
	
	private Integer fridayNumberOfBookedPersons;
	
	private Integer saturdayNumberOfBookedPersons;
	
	private Integer sundayNumberOfBookedPersons;
	
	public Long getPoolId() {
		return poolId;
	}

	public String getDriverAdditionalDetails() {
		return driverAdditionalDetails;
	}

	public String getFromRegionName() {
		return fromRegionName;
	}

	public String getFromAreaName() {
		return fromAreaName;
	}

	public String getToRegionName() {
		return toRegionName;
	}

	public String getToAreaName() {
		return toAreaName;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public LocalTime getReturnTime() {
		return returnTime;
	}

	public Boolean getSmoker() {
		return smoker;
	}

	public Integer getMondayNumberOfBookedPersons() {
		return mondayNumberOfBookedPersons;
	}

	public Integer getTuesdayNumberOfBookedPersons() {
		return tuesdayNumberOfBookedPersons;
	}

	public Integer getWednesdayNumberOfBookedPersons() {
		return wednesdayNumberOfBookedPersons;
	}

	public Integer getThursdayNumberOfBookedPersons() {
		return thursdayNumberOfBookedPersons;
	}

	public Integer getFridayNumberOfBookedPersons() {
		return fridayNumberOfBookedPersons;
	}

	public Integer getSaturdayNumberOfBookedPersons() {
		return saturdayNumberOfBookedPersons;
	}

	public Integer getSundayNumberOfBookedPersons() {
		return sundayNumberOfBookedPersons;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public void setDriverAdditionalDetails(String driverAdditionalDetails) {
		this.driverAdditionalDetails = driverAdditionalDetails;
	}

	public void setFromRegionName(String fromRegionName) {
		this.fromRegionName = fromRegionName;
	}

	public void setFromAreaName(String fromAreaName) {
		this.fromAreaName = fromAreaName;
	}

	public void setToRegionName(String toRegionName) {
		this.toRegionName = toRegionName;
	}

	public void setToAreaName(String toAreaName) {
		this.toAreaName = toAreaName;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setReturnTime(LocalTime returnTime) {
		this.returnTime = returnTime;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}

	public void setMondayNumberOfBookedPersons(Integer mondayNumberOfBookedPersons) {
		this.mondayNumberOfBookedPersons = mondayNumberOfBookedPersons;
	}

	public void setTuesdayNumberOfBookedPersons(Integer tuesdayNumberOfBookedPersons) {
		this.tuesdayNumberOfBookedPersons = tuesdayNumberOfBookedPersons;
	}

	public void setWednesdayNumberOfBookedPersons(
			Integer wednesdayNumberOfBookedPersons) {
		this.wednesdayNumberOfBookedPersons = wednesdayNumberOfBookedPersons;
	}

	public void setThursdayNumberOfBookedPersons(
			Integer thursdayNumberOfBookedPersons) {
		this.thursdayNumberOfBookedPersons = thursdayNumberOfBookedPersons;
	}

	public void setFridayNumberOfBookedPersons(Integer fridayNumberOfBookedPersons) {
		this.fridayNumberOfBookedPersons = fridayNumberOfBookedPersons;
	}

	public void setSaturdayNumberOfBookedPersons(
			Integer saturdayNumberOfBookedPersons) {
		this.saturdayNumberOfBookedPersons = saturdayNumberOfBookedPersons;
	}

	public void setSundayNumberOfBookedPersons(Integer sundayNumberOfBookedPersons) {
		this.sundayNumberOfBookedPersons = sundayNumberOfBookedPersons;
	}
	
}
