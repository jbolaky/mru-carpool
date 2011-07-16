package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.javaid.bolaky.carpool.service.hibernate.constraint.TravelDays;

@TravelDays
public class PoolRegistrationVO implements Serializable {

	private static final long serialVersionUID = -6418987354269415624L;

	private String username;

	private Integer poolCode;

	/** start of page 1 attributes */
	private boolean carOwner;

	private boolean validLicense;

	private boolean smoker;

	private Integer maxNumberOfSeats;

	private String vehicleMake;

	private String vehicleModel;

	private String vehicleType;
	/** end of page 1 attributes */

	private String carpoolName;

	private LocalDate startingCarpoolDate;

	private LocalDate endOfPoolDate;

	private LocalTime departureTime;

	private Integer numberOfCurrentPassengers;

	private String fromAreaCode;

	private String fromDistrictCode;

	private boolean oneWayTravel;

	private Character genderToTravelWith;

	private boolean shareCost;

	private boolean travelOnMonday;

	private Integer numberOfAvailableSeatsOnMonday;

	private boolean travelOnTuesday;

	private Integer numberOfAvailableSeatsOnTuesday;

	private boolean travelOnWednesday;

	private Integer numberOfAvailableSeatsOnWednesday;

	private boolean travelOnThursday;

	private Integer numberOfAvailableSeatsOnThursday;

	private boolean travelOnFriday;

	private Integer numberOfAvailableSeatsOnFriday;

	private boolean travelOnSaturday;

	private Integer numberOfAvailableSeatsOnSaturday;

	private boolean travelOnSunday;

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

	public Integer getPoolCode() {
		return poolCode;
	}

	public String getUsername() {
		return username;
	}

	public boolean getCarOwner() {
		return carOwner;
	}

	public boolean getValidLicense() {
		return validLicense;
	}

	public boolean getSmoker() {
		return smoker;
	}

	public Integer getMaxNumberOfSeats() {
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

	public String getCarpoolName() {
		return carpoolName;
	}

	public LocalDate getStartingCarpoolDate() {
		return startingCarpoolDate;
	}

	public LocalDate getEndOfPoolDate() {
		return endOfPoolDate;
	}

	public Integer getNumberOfCurrentPassengers() {
		return numberOfCurrentPassengers;
	}

	public String getFromAreaCode() {
		return fromAreaCode;
	}

	public String getFromDistrictCode() {
		return fromDistrictCode;
	}

	public boolean getOneWayTravel() {
		return oneWayTravel;
	}

	public Character getGenderToTravelWith() {
		return genderToTravelWith;
	}

	public boolean getShareCost() {
		return shareCost;
	}

	public boolean getTravelOnMonday() {
		return travelOnMonday;
	}

	public Integer getNumberOfAvailableSeatsOnMonday() {
		return numberOfAvailableSeatsOnMonday;
	}

	public boolean getTravelOnTuesday() {
		return travelOnTuesday;
	}

	public Integer getNumberOfAvailableSeatsOnTuesday() {
		return numberOfAvailableSeatsOnTuesday;
	}

	public boolean getTravelOnWednesday() {
		return travelOnWednesday;
	}

	public Integer getNumberOfAvailableSeatsOnWednesday() {
		return numberOfAvailableSeatsOnWednesday;
	}

	public boolean getTravelOnThursday() {
		return travelOnThursday;
	}

	public Integer getNumberOfAvailableSeatsOnThursday() {
		return numberOfAvailableSeatsOnThursday;
	}

	public boolean getTravelOnFriday() {
		return travelOnFriday;
	}

	public Integer getNumberOfAvailableSeatsOnFriday() {
		return numberOfAvailableSeatsOnFriday;
	}

	public boolean getTravelOnSaturday() {
		return travelOnSaturday;
	}

	public Integer getNumberOfAvailableSeatsOnSaturday() {
		return numberOfAvailableSeatsOnSaturday;
	}

	public boolean getTravelOnSunday() {
		return travelOnSunday;
	}

	public Integer getNumberOfAvailableSeatsOnSunday() {
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

	public void setPoolCode(Integer poolCode) {
		this.poolCode = poolCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCarOwner(boolean carOwner) {
		this.carOwner = carOwner;
	}

	public void setValidLicense(boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public void setMaxNumberOfSeats(Integer maxNumberOfSeats) {
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

	public void setCarpoolName(String carpoolName) {
		this.carpoolName = carpoolName;
	}

	public void setStartingCarpoolDate(LocalDate startingCarpoolDate) {
		this.startingCarpoolDate = startingCarpoolDate;
	}

	public void setEndOfPoolDate(LocalDate endOfPoolDate) {
		this.endOfPoolDate = endOfPoolDate;
	}

	public void setNumberOfCurrentPassengers(Integer numberOfCurrentPassengers) {
		this.numberOfCurrentPassengers = numberOfCurrentPassengers;
	}

	public void setFromAreaCode(String fromAreaCode) {
		this.fromAreaCode = fromAreaCode;
	}

	public void setFromDistrictCode(String fromDistrictCode) {
		this.fromDistrictCode = fromDistrictCode;
	}

	public void setOneWayTravel(boolean oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setGenderToTravelWith(Character genderToTravelWith) {
		this.genderToTravelWith = genderToTravelWith;
	}

	public void setShareCost(boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setTravelOnMonday(boolean travelOnMonday) {
		this.travelOnMonday = travelOnMonday;
	}

	public void setNumberOfAvailableSeatsOnMonday(
			Integer numberOfAvailableSeatsOnMonday) {
		this.numberOfAvailableSeatsOnMonday = numberOfAvailableSeatsOnMonday;
	}

	public void setTravelOnTuesday(boolean travelOnTuesday) {
		this.travelOnTuesday = travelOnTuesday;
	}

	public void setNumberOfAvailableSeatsOnTuesday(
			Integer numberOfAvailableSeatsOnTuesday) {
		this.numberOfAvailableSeatsOnTuesday = numberOfAvailableSeatsOnTuesday;
	}

	public void setTravelOnWednesday(boolean travelOnWednesday) {
		this.travelOnWednesday = travelOnWednesday;
	}

	public void setNumberOfAvailableSeatsOnWednesday(
			Integer numberOfAvailableSeatsOnWednesday) {
		this.numberOfAvailableSeatsOnWednesday = numberOfAvailableSeatsOnWednesday;
	}

	public void setTravelOnThursday(boolean travelOnThursday) {
		this.travelOnThursday = travelOnThursday;
	}

	public void setNumberOfAvailableSeatsOnThursday(
			Integer numberOfAvailableSeatsOnThursday) {
		this.numberOfAvailableSeatsOnThursday = numberOfAvailableSeatsOnThursday;
	}

	public void setTravelOnFriday(boolean travelOnFriday) {
		this.travelOnFriday = travelOnFriday;
	}

	public void setNumberOfAvailableSeatsOnFriday(
			Integer numberOfAvailableSeatsOnFriday) {
		this.numberOfAvailableSeatsOnFriday = numberOfAvailableSeatsOnFriday;
	}

	public void setTravelOnSaturday(boolean travelOnSaturday) {
		this.travelOnSaturday = travelOnSaturday;
	}

	public void setNumberOfAvailableSeatsOnSaturday(
			Integer numberOfAvailableSeatsOnSaturday) {
		this.numberOfAvailableSeatsOnSaturday = numberOfAvailableSeatsOnSaturday;
	}

	public void setTravelOnSunday(boolean travelOnSunday) {
		this.travelOnSunday = travelOnSunday;
	}

	public void setNumberOfAvailableSeatsOnSunday(
			Integer numberOfAvailableSeatsOnSunday) {
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
