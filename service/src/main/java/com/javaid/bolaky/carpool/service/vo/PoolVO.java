package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class PoolVO implements Serializable {

	private static final long serialVersionUID = -6388429953779198840L;

	private Long poolId;
	
	private String addtionalDetails;

	private LocalTime departureTime;

	private String fromRegionName;

	private String fromAreaName;

	private LocalTime arrivalTime;

	private String toRegionName;

	private String toAreaName;

	private Boolean oneWayReturn;

	private Boolean vehicleOwner;

	private String vehicleMake;

	private String vehicleModel;

	private String vehicleType;

	private Boolean validLicense;

	private Boolean smoker;

	private Boolean shareCost;

	private Character driverGender;

	private Character prefferedGenderToTravelWith;

	private Integer numberOfPassengers;

	private LocalDate startDate;

	private LocalDate endDate;

	private PoolType poolType;
	
	public Long getPoolId() {
		return poolId;
	}

	public String getAddtionalDetails() {
		return addtionalDetails;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public String getFromRegionName() {
		return fromRegionName;
	}

	public String getFromAreaName() {
		return fromAreaName;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public String getToRegionName() {
		return toRegionName;
	}

	public String getToAreaName() {
		return toAreaName;
	}

	public Boolean getOneWayReturn() {
		return oneWayReturn;
	}

	public Boolean getVehicleOwner() {
		return vehicleOwner;
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

	public Boolean getValidLicense() {
		return validLicense;
	}

	public Boolean getSmoker() {
		return smoker;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public Character getDriverGender() {
		return driverGender;
	}

	public Character getPrefferedGenderToTravelWith() {
		return prefferedGenderToTravelWith;
	}

	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public PoolType getPoolType() {
		return poolType;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public void setAddtionalDetails(String addtionalDetails) {
		this.addtionalDetails = addtionalDetails;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setFromRegionName(String fromRegionName) {
		this.fromRegionName = fromRegionName;
	}

	public void setFromAreaName(String fromAreaName) {
		this.fromAreaName = fromAreaName;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setToRegionName(String toRegionName) {
		this.toRegionName = toRegionName;
	}

	public void setToAreaName(String toAreaName) {
		this.toAreaName = toAreaName;
	}

	public void setOneWayReturn(Boolean oneWayReturn) {
		this.oneWayReturn = oneWayReturn;
	}

	public void setVehicleOwner(Boolean vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
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

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setDriverGender(Character driverGender) {
		this.driverGender = driverGender;
	}

	public void setPrefferedGenderToTravelWith(
			Character prefferedGenderToTravelWith) {
		this.prefferedGenderToTravelWith = prefferedGenderToTravelWith;
	}

	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setPoolType(PoolType poolType) {
		this.poolType = poolType;
	}

}
