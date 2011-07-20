package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.javaid.bolaky.carpool.service.hibernate.constraint.TravelDays;

@TravelDays
public class PoolRegistrationVO implements Serializable {

	private static final long serialVersionUID = -6418987354269415624L;

	private String username;

	/** start of page 1 attributes */
	private PoolType poolCode;

	private Boolean carOwner;

	private Boolean validLicense;

	private Boolean smoker;

	private String maxNumberOfSeats;

	private String vehicleMake;

	private String vehicleModel;

	private String vehicleType;
	/** end of page 1 attributes */

	/** start of page 2 attributes */
	private String poolName;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate startingPoolDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate endOfPoolDate;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime departureTime;

	private String numberOfCurrentPassengers;

	private String fromAreaCode;

	private String fromDistrictCode;

	private Boolean oneWayTravel;

	private String genderToTravelWith;

	private Boolean shareCost;
	/** end of page 2 attributes */

	/** start of page 3 attributes */
	private Boolean travelOnMonday;

	private String numberOfAvailableSeatsOnMonday;

	private Boolean travelOnTuesday;

	private String numberOfAvailableSeatsOnTuesday;

	private Boolean travelOnWednesday;

	private String numberOfAvailableSeatsOnWednesday;

	private Boolean travelOnThursday;

	private String numberOfAvailableSeatsOnThursday;

	private Boolean travelOnFriday;

	private String numberOfAvailableSeatsOnFriday;

	private Boolean travelOnSaturday;

	private String numberOfAvailableSeatsOnSaturday;

	private Boolean travelOnSunday;

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

	public PoolType getPoolCode() {
		return poolCode;
	}

	public String getUsername() {
		return username;
	}

	public Boolean getCarOwner() {
		return carOwner;
	}

	public Boolean getValidLicense() {
		return validLicense;
	}

	public Boolean getSmoker() {
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

	public LocalDate getStartingPoolDate() {
		return startingPoolDate;
	}

	public LocalDate getEndOfPoolDate() {
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

	public Boolean getOneWayTravel() {
		return oneWayTravel;
	}

	public String getGenderToTravelWith() {
		return genderToTravelWith;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public Boolean getTravelOnMonday() {
		return travelOnMonday;
	}

	public String getNumberOfAvailableSeatsOnMonday() {
		return numberOfAvailableSeatsOnMonday;
	}

	public Boolean getTravelOnTuesday() {
		return travelOnTuesday;
	}

	public String getNumberOfAvailableSeatsOnTuesday() {
		return numberOfAvailableSeatsOnTuesday;
	}

	public Boolean getTravelOnWednesday() {
		return travelOnWednesday;
	}

	public String getNumberOfAvailableSeatsOnWednesday() {
		return numberOfAvailableSeatsOnWednesday;
	}

	public Boolean getTravelOnThursday() {
		return travelOnThursday;
	}

	public String getNumberOfAvailableSeatsOnThursday() {
		return numberOfAvailableSeatsOnThursday;
	}

	public Boolean getTravelOnFriday() {
		return travelOnFriday;
	}

	public String getNumberOfAvailableSeatsOnFriday() {
		return numberOfAvailableSeatsOnFriday;
	}

	public Boolean getTravelOnSaturday() {
		return travelOnSaturday;
	}

	public String getNumberOfAvailableSeatsOnSaturday() {
		return numberOfAvailableSeatsOnSaturday;
	}

	public Boolean getTravelOnSunday() {
		return travelOnSunday;
	}

	public String getNumberOfAvailableSeatsOnSunday() {
		return numberOfAvailableSeatsOnSunday;
	}

	public LocalTime getDepartureTime() {
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

	public void setPoolCode(PoolType poolCode) {
		this.poolCode = poolCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCarOwner(Boolean carOwner) {
		this.carOwner = carOwner;
	}

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setSmoker(Boolean smoker) {
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

	public void setStartingPoolDate(LocalDate startingPoolDate) {
		this.startingPoolDate = startingPoolDate;
	}

	public void setEndOfPoolDate(LocalDate endOfPoolDate) {
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

	public void setOneWayTravel(Boolean oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setGenderToTravelWith(String genderToTravelWith) {
		this.genderToTravelWith = genderToTravelWith;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setTravelOnMonday(Boolean travelOnMonday) {
		this.travelOnMonday = travelOnMonday;
	}

	public void setNumberOfAvailableSeatsOnMonday(
			String numberOfAvailableSeatsOnMonday) {
		this.numberOfAvailableSeatsOnMonday = numberOfAvailableSeatsOnMonday;
	}

	public void setTravelOnTuesday(Boolean travelOnTuesday) {
		this.travelOnTuesday = travelOnTuesday;
	}

	public void setNumberOfAvailableSeatsOnTuesday(
			String numberOfAvailableSeatsOnTuesday) {
		this.numberOfAvailableSeatsOnTuesday = numberOfAvailableSeatsOnTuesday;
	}

	public void setTravelOnWednesday(Boolean travelOnWednesday) {
		this.travelOnWednesday = travelOnWednesday;
	}

	public void setNumberOfAvailableSeatsOnWednesday(
			String numberOfAvailableSeatsOnWednesday) {
		this.numberOfAvailableSeatsOnWednesday = numberOfAvailableSeatsOnWednesday;
	}

	public void setTravelOnThursday(Boolean travelOnThursday) {
		this.travelOnThursday = travelOnThursday;
	}

	public void setNumberOfAvailableSeatsOnThursday(
			String numberOfAvailableSeatsOnThursday) {
		this.numberOfAvailableSeatsOnThursday = numberOfAvailableSeatsOnThursday;
	}

	public void setTravelOnFriday(Boolean travelOnFriday) {
		this.travelOnFriday = travelOnFriday;
	}

	public void setNumberOfAvailableSeatsOnFriday(
			String numberOfAvailableSeatsOnFriday) {
		this.numberOfAvailableSeatsOnFriday = numberOfAvailableSeatsOnFriday;
	}

	public void setTravelOnSaturday(Boolean travelOnSaturday) {
		this.travelOnSaturday = travelOnSaturday;
	}

	public void setNumberOfAvailableSeatsOnSaturday(
			String numberOfAvailableSeatsOnSaturday) {
		this.numberOfAvailableSeatsOnSaturday = numberOfAvailableSeatsOnSaturday;
	}

	public void setTravelOnSunday(Boolean travelOnSunday) {
		this.travelOnSunday = travelOnSunday;
	}

	public void setNumberOfAvailableSeatsOnSunday(
			String numberOfAvailableSeatsOnSunday) {
		this.numberOfAvailableSeatsOnSunday = numberOfAvailableSeatsOnSunday;
	}

	public void setDepartureTime(LocalTime departureTime) {
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
