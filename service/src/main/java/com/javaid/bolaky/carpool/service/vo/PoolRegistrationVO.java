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

	/** start of page 3 attributes */
	private String travelOnMonday;

	private String numberOfAvailableSeatsOnMonday;

	private String travelOnTuesday;

	private String numberOfAvailableSeatsOnTuesday;

	private String travelOnWednesday;

	private String numberOfAvailableSeatsOnWednesday;

	private String travelOnThursday;

	private String numberOfAvailableSeatsOnThursday;

	private String travelOnFriday;

	private String numberOfAvailableSeatsOnFriday;

	private String travelOnSaturday;

	private String numberOfAvailableSeatsOnSaturday;

	private String travelOnSunday;

	private String numberOfAvailableSeatsOnSunday;

	private String toAreaCode;

	private String toDistrictCode;

	private String additionalDetails;
	/** end of page 3 attributes */

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

	public String getTravelOnMonday() {
		return travelOnMonday;
	}

	public String getNumberOfAvailableSeatsOnMonday() {
		return numberOfAvailableSeatsOnMonday;
	}

	public String getTravelOnTuesday() {
		return travelOnTuesday;
	}

	public String getNumberOfAvailableSeatsOnTuesday() {
		return numberOfAvailableSeatsOnTuesday;
	}

	public String getTravelOnWednesday() {
		return travelOnWednesday;
	}

	public String getNumberOfAvailableSeatsOnWednesday() {
		return numberOfAvailableSeatsOnWednesday;
	}

	public String getTravelOnThursday() {
		return travelOnThursday;
	}

	public String getNumberOfAvailableSeatsOnThursday() {
		return numberOfAvailableSeatsOnThursday;
	}

	public String getTravelOnFriday() {
		return travelOnFriday;
	}

	public String getNumberOfAvailableSeatsOnFriday() {
		return numberOfAvailableSeatsOnFriday;
	}

	public String getTravelOnSaturday() {
		return travelOnSaturday;
	}

	public String getNumberOfAvailableSeatsOnSaturday() {
		return numberOfAvailableSeatsOnSaturday;
	}

	public String getTravelOnSunday() {
		return travelOnSunday;
	}

	public String getNumberOfAvailableSeatsOnSunday() {
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

	public void setTravelOnMonday(String travelOnMonday) {
		this.travelOnMonday = travelOnMonday;
	}

	public void setNumberOfAvailableSeatsOnMonday(
			String numberOfAvailableSeatsOnMonday) {
		this.numberOfAvailableSeatsOnMonday = numberOfAvailableSeatsOnMonday;
	}

	public void setTravelOnTuesday(String travelOnTuesday) {
		this.travelOnTuesday = travelOnTuesday;
	}

	public void setNumberOfAvailableSeatsOnTuesday(
			String numberOfAvailableSeatsOnTuesday) {
		this.numberOfAvailableSeatsOnTuesday = numberOfAvailableSeatsOnTuesday;
	}

	public void setTravelOnWednesday(String travelOnWednesday) {
		this.travelOnWednesday = travelOnWednesday;
	}

	public void setNumberOfAvailableSeatsOnWednesday(
			String numberOfAvailableSeatsOnWednesday) {
		this.numberOfAvailableSeatsOnWednesday = numberOfAvailableSeatsOnWednesday;
	}

	public void setTravelOnThursday(String travelOnThursday) {
		this.travelOnThursday = travelOnThursday;
	}

	public void setNumberOfAvailableSeatsOnThursday(
			String numberOfAvailableSeatsOnThursday) {
		this.numberOfAvailableSeatsOnThursday = numberOfAvailableSeatsOnThursday;
	}

	public void setTravelOnFriday(String travelOnFriday) {
		this.travelOnFriday = travelOnFriday;
	}

	public void setNumberOfAvailableSeatsOnFriday(
			String numberOfAvailableSeatsOnFriday) {
		this.numberOfAvailableSeatsOnFriday = numberOfAvailableSeatsOnFriday;
	}

	public void setTravelOnSaturday(String travelOnSaturday) {
		this.travelOnSaturday = travelOnSaturday;
	}

	public void setNumberOfAvailableSeatsOnSaturday(
			String numberOfAvailableSeatsOnSaturday) {
		this.numberOfAvailableSeatsOnSaturday = numberOfAvailableSeatsOnSaturday;
	}

	public void setTravelOnSunday(String travelOnSunday) {
		this.travelOnSunday = travelOnSunday;
	}

	public void setNumberOfAvailableSeatsOnSunday(
			String numberOfAvailableSeatsOnSunday) {
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
