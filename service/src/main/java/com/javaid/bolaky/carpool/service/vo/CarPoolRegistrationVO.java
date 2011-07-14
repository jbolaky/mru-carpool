package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.javaid.bolaky.carpool.service.hibernate.constraint.TravelDays;

@TravelDays
public class CarPoolRegistrationVO implements Serializable {

	private static final long serialVersionUID = -6418987354269415624L;

	private String username;

	private Integer poolCode;

	@NotNull(message = "S110")
	private Boolean carOwner;

	@NotNull(message = "S115")
	private Boolean validLicense;

	@NotNull(message = "S120")
	private Character gender;

	@NotNull(message = "S125")
	private Boolean smoker;

	private Integer maxNumberOfSeats;

	@NotNull(message = "S130")
	private String vehicleMake;

	@NotNull(message = "S135")
	private String vehicleModel;

	@NotNull(message = "S140")
	private String vehicleType;

	@NotNull(message = "S145")
	@NotEmpty(message = "S145")
	private String carpoolName;

	@NotNull(message = "S150")
	@NotEmpty(message = "S150")
	private LocalDate startingCarpoolDate;
	
	private LocalDate endOfPoolDate;
	
	@NotEmpty(message = "S205")
	@NotNull(message = "S205")
	private LocalTime departureTime;

	@NotNull(message = "S155")
	private Integer numberOfCurrentPassengers;

	@NotNull(message = "S160")
	private String fromAreaCode;

	@NotNull(message = "S165")
	private String fromDistrictCode;

	@NotNull(message = "S170")
	private Boolean oneWayTravel;

	@NotNull(message = "S175")
	private Character genderToTravelWith;

	@NotNull(message = "S180")
	private Boolean shareCost;

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

	@NotEmpty(message = "S210")
	@NotNull(message = "S210")
	private String toAreaCode;

	@NotEmpty(message = "S215")
	@NotNull(message = "S215")
	private String toDistrictCode;

	private String additionalDetails;

	public CarPoolRegistrationVO() {
		super();
	}

	public CarPoolRegistrationVO(String username) {
		super();
		this.username = username;
	}

	public Integer getPoolCode() {
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

	public Character getGender() {
		return gender;
	}

	public Boolean getSmoker() {
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

	public Boolean getOneWayTravel() {
		return oneWayTravel;
	}

	public Character getGenderToTravelWith() {
		return genderToTravelWith;
	}

	public Boolean getShareCost() {
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

	public void setCarOwner(Boolean carOwner) {
		this.carOwner = carOwner;
	}

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public void setSmoker(Boolean smoker) {
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

	public void setOneWayTravel(Boolean oneWayTravel) {
		this.oneWayTravel = oneWayTravel;
	}

	public void setGenderToTravelWith(Character genderToTravelWith) {
		this.genderToTravelWith = genderToTravelWith;
	}

	public void setShareCost(Boolean shareCost) {
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
