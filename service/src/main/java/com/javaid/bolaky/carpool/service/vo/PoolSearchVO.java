package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

public class PoolSearchVO implements Serializable {

	private static final long serialVersionUID = 4851516260160661471L;

	private Boolean mondaySelected;

	private Boolean tuesdaySelected;

	private Boolean wednesdaySelected;

	private Boolean thursdaySelected;

	private Boolean fridaySelected;

	private Boolean saturdaySelected;

	private Boolean sundaySelected;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime earliestDepartureTime;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime latestDepartureTime;

	private Boolean oneWayTravel;

	private String fromDistictCode;

	private String fromAreaCode;

	private String toDistrictCode;

	private String toAreaCode;

	private Integer ageGroup;

	private String numberOfPassengers;

	private Character driverGender;

	private Boolean shareCost;

	public Boolean getMondaySelected() {
		return mondaySelected;
	}

	public Boolean getTuesdaySelected() {
		return tuesdaySelected;
	}

	public Boolean getWednesdaySelected() {
		return wednesdaySelected;
	}

	public Boolean getThursdaySelected() {
		return thursdaySelected;
	}

	public Boolean getFridaySelected() {
		return fridaySelected;
	}

	public Boolean getSaturdaySelected() {
		return saturdaySelected;
	}

	public Boolean getSundaySelected() {
		return sundaySelected;
	}

	public LocalTime getEarliestDepartureTime() {
		return earliestDepartureTime;
	}

	public LocalTime getLatestDepartureTime() {
		return latestDepartureTime;
	}

	public Character getDriverGender() {
		return driverGender;
	}

	public Boolean getOneWayTravel() {
		return oneWayTravel;
	}

	public String getFromDistictCode() {
		return fromDistictCode;
	}

	public String getFromAreaCode() {
		return fromAreaCode;
	}

	public String getToDistrictCode() {
		return toDistrictCode;
	}

	public String getToAreaCode() {
		return toAreaCode;
	}

	public Integer getAgeGroup() {
		return ageGroup;
	}

	public String getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public void setMondaySelected(Boolean mondaySelected) {
		this.mondaySelected = mondaySelected;
	}

	public void setTuesdaySelected(Boolean tuesdaySelected) {
		this.tuesdaySelected = tuesdaySelected;
	}

	public void setWednesdaySelected(Boolean wednesdaySelected) {
		this.wednesdaySelected = wednesdaySelected;
	}

	public void setThursdaySelected(Boolean thursdaySelected) {
		this.thursdaySelected = thursdaySelected;
	}

	public void setFridaySelected(Boolean fridaySelected) {
		this.fridaySelected = fridaySelected;
	}

	public void setSaturdaySelected(Boolean saturdaySelected) {
		this.saturdaySelected = saturdaySelected;
	}

	public void setSundaySelected(Boolean sundaySelected) {
		this.sundaySelected = sundaySelected;
	}

	public void setEarliestDepartureTime(LocalTime earliestDepartureTime) {
		this.earliestDepartureTime = earliestDepartureTime;
	}

	public void setLatestDepartureTime(LocalTime latestDepartureTime) {
		this.latestDepartureTime = latestDepartureTime;
	}

	public void setOneWayTravel(Boolean oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setFromDistictCode(String fromDistictCode) {
		this.fromDistictCode = fromDistictCode;
	}

	public void setFromAreaCode(String fromAreaCode) {
		this.fromAreaCode = fromAreaCode;
	}

	public void setToDistrictCode(String toDistrictCode) {
		this.toDistrictCode = toDistrictCode;
	}

	public void setToAreaCode(String toAreaCode) {
		this.toAreaCode = toAreaCode;
	}

	public void setAgeGroup(Integer ageGroup) {
		this.ageGroup = ageGroup;
	}

	public void setNumberOfPassengers(String numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public void setDriverGender(Character driverGender) {
		this.driverGender = driverGender;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

}
