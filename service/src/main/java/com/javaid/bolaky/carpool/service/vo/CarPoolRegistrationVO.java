package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;
import java.util.Date;

public class CarPoolRegistrationVO implements Serializable {

	private static final long serialVersionUID = -6418987354269415624L;

	private String username;

	private Boolean carOwner;

	private Boolean validLicense;

	private Character gender;

	private Boolean smoker;

	private String vehicleMake;

	private String vehicleModel;

	private String vehicleType;

	private String carpoolName;

	private Date carpoolDate;

	private Integer numberOfCurrentPassengers;

	private String fromAreaCode;

	private String fromDistrictCode;

	private Boolean oneWayTravel;

	private Character genderToTravelWith;

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

	private Date departureTime;

	private String toAreaCode;

	private String toDistrictCode;

	private String additionalDetails;

	public CarPoolRegistrationVO() {
		super();
	}

	public CarPoolRegistrationVO(String username) {
		super();
		this.username = username;
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

	public Date getCarpoolDate() {
		return carpoolDate;
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

	public Date getDepartureTime() {
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

	public void setCarpoolDate(Date carpoolDate) {
		this.carpoolDate = carpoolDate;
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

	public void setDepartureTime(Date departureTime) {
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