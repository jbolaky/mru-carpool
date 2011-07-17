package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import com.javaid.bolaky.carpool.service.hibernate.constraint.TravelDays;

@TravelDays
public class PoolRegistrationVO implements Serializable {

	private static final long serialVersionUID = -6418987354269415624L;

	private String username;

	/** start of page 1 attributes */
	private String poolCode;

	private String carOwner;

	private String validLicense;

	private String smoker;

	private String maxNumberOfSeats;

	private String vehicleMake;

	private String vehicleModel;

	private String vehicleType;
	/** end of page 1 attributes */

	/** start of page 2 attributes */
	private String poolName;

	private String startingPoolDate;

	private String endOfPoolDate;

	private String departureTime;

	private String numberOfCurrentPassengers;

	private String fromAreaCode;

	private String fromDistrictCode;

	private String oneWayTravel;

	private String genderToTravelWith;

	private String shareCost;
	/** end of page 2 attributes */

	private Boolean travelOnMonday;

	private Integer numberOfAvailableSeatsOnMonday;

	private Boolean travelOnTuesday;

	private Integer numberOfAvailableSeatsOnTuesday;

	private Boolean travelOnWednesday;

	private Integer numberOfAvailableSeatsOnWednesday;

	private Boolean travelOnThursday;

	private Integer numberOfAvailableSeatsOnThursday;

	private Boolean travelOnFriday;

	private Integer numberOfAvailableSeatsOnFriday;

	private Boolean travelOnSaturday;

	private Integer numberOfAvailableSeatsOnSaturday;

	private Boolean travelOnSunday;

	private Integer numberOfAvailableSeatsOnSunday;

	private String toAreaCode;

	private String toDistrictCode;

	private String additionalDetails;

	public PoolRegistrationVO() {
		super();
	}

	public PoolRegistrationVO(String username) {
		super();
		this.username = username;
	}

	public String getPoolCode() {
		return poolCode;
	}

	public String getUsername() {
		return username;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public String getValidLicense() {
		return validLicense;
	}

	public String getSmoker() {
		return smoker;
	}

	public String getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getPoolName() {
		return poolName;
	}

	public String getStartingPoolDate() {
		return startingPoolDate;
	}

	public String getEndOfPoolDate() {
		return endOfPoolDate;
	}

	public String getNumberOfCurrentPassengers() {
		return numberOfCurrentPassengers;
	}

	public String getFromAreaCode() {
		return fromAreaCode;
	}

	public String getFromDistrictCode() {
		return fromDistrictCode;
	}

	public String getOneWayTravel() {
		return oneWayTravel;
	}

	public String getGenderToTravelWith() {
		return genderToTravelWith;
	}

	public String getShareCost() {
		return shareCost;
	}

	public Boolean getTravelOnMonday() {
		return travelOnMonday;
	}

	public Integer getNumberOfAvailableSeatsOnMonday() {
		return numberOfAvailableSeatsOnMonday;
	}

	public Boolean getTravelOnTuesday() {
		return travelOnTuesday;
	}

	public Integer getNumberOfAvailableSeatsOnTuesday() {
		return numberOfAvailableSeatsOnTuesday;
	}

	public Boolean getTravelOnWednesday() {
		return travelOnWednesday;
	}

	public Integer getNumberOfAvailableSeatsOnWednesday() {
		return numberOfAvailableSeatsOnWednesday;
	}

	public Boolean getTravelOnThursday() {
		return travelOnThursday;
	}

	public Integer getNumberOfAvailableSeatsOnThursday() {
		return numberOfAvailableSeatsOnThursday;
	}

	public Boolean getTravelOnFriday() {
		return travelOnFriday;
	}

	public Integer getNumberOfAvailableSeatsOnFriday() {
		return numberOfAvailableSeatsOnFriday;
	}

	public Boolean getTravelOnSaturday() {
		return travelOnSaturday;
	}

	public Integer getNumberOfAvailableSeatsOnSaturday() {
		return numberOfAvailableSeatsOnSaturday;
	}

	public Boolean getTravelOnSunday() {
		return travelOnSunday;
	}

	public Integer getNumberOfAvailableSeatsOnSunday() {
		return numberOfAvailableSeatsOnSunday;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getToAreaCode() {
		return toAreaCode;
	}

	public String getToDistrictCode() {
		return toDistrictCode;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setPoolCode(String poolCode) {
		this.poolCode = poolCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	public void setValidLicense(String validLicense) {
		this.validLicense = validLicense;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public void setMaxNumberOfSeats(String maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public void setStartingPoolDate(String startingPoolDate) {
		this.startingPoolDate = startingPoolDate;
	}

	public void setEndOfPoolDate(String endOfPoolDate) {
		this.endOfPoolDate = endOfPoolDate;
	}

	public void setNumberOfCurrentPassengers(String numberOfCurrentPassengers) {
		this.numberOfCurrentPassengers = numberOfCurrentPassengers;
	}

	public void setFromAreaCode(String fromAreaCode) {
		this.fromAreaCode = fromAreaCode;
	}

	public void setFromDistrictCode(String fromDistrictCode) {
		this.fromDistrictCode = fromDistrictCode;
	}

	public void setOneWayTravel(String oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setGenderToTravelWith(String genderToTravelWith) {
		this.genderToTravelWith = genderToTravelWith;
	}

	public void setShareCost(String shareCost) {
		this.shareCost = shareCost;
	}

	public void setTravelOnMonday(Boolean travelOnMonday) {
		this.travelOnMonday = travelOnMonday;
	}

	public void setNumberOfAvailableSeatsOnMonday(
			Integer numberOfAvailableSeatsOnMonday) {
		this.numberOfAvailableSeatsOnMonday = numberOfAvailableSeatsOnMonday;
	}

	public void setTravelOnTuesday(Boolean travelOnTuesday) {
		this.travelOnTuesday = travelOnTuesday;
	}

	public void setNumberOfAvailableSeatsOnTuesday(
			Integer numberOfAvailableSeatsOnTuesday) {
		this.numberOfAvailableSeatsOnTuesday = numberOfAvailableSeatsOnTuesday;
	}

	public void setTravelOnWednesday(Boolean travelOnWednesday) {
		this.travelOnWednesday = travelOnWednesday;
	}

	public void setNumberOfAvailableSeatsOnWednesday(
			Integer numberOfAvailableSeatsOnWednesday) {
		this.numberOfAvailableSeatsOnWednesday = numberOfAvailableSeatsOnWednesday;
	}

	public void setTravelOnThursday(Boolean travelOnThursday) {
		this.travelOnThursday = travelOnThursday;
	}

	public void setNumberOfAvailableSeatsOnThursday(
			Integer numberOfAvailableSeatsOnThursday) {
		this.numberOfAvailableSeatsOnThursday = numberOfAvailableSeatsOnThursday;
	}

	public void setTravelOnFriday(Boolean travelOnFriday) {
		this.travelOnFriday = travelOnFriday;
	}

	public void setNumberOfAvailableSeatsOnFriday(
			Integer numberOfAvailableSeatsOnFriday) {
		this.numberOfAvailableSeatsOnFriday = numberOfAvailableSeatsOnFriday;
	}

	public void setTravelOnSaturday(Boolean travelOnSaturday) {
		this.travelOnSaturday = travelOnSaturday;
	}

	public void setNumberOfAvailableSeatsOnSaturday(
			Integer numberOfAvailableSeatsOnSaturday) {
		this.numberOfAvailableSeatsOnSaturday = numberOfAvailableSeatsOnSaturday;
	}

	public void setTravelOnSunday(Boolean travelOnSunday) {
		this.travelOnSunday = travelOnSunday;
	}

	public void setNumberOfAvailableSeatsOnSunday(
			Integer numberOfAvailableSeatsOnSunday) {
		this.numberOfAvailableSeatsOnSunday = numberOfAvailableSeatsOnSunday;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setToAreaCode(String toAreaCode) {
		this.toAreaCode = toAreaCode;
	}

	public void setToDistrictCode(String toDistrictCode) {
		this.toDistrictCode = toDistrictCode;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

}
