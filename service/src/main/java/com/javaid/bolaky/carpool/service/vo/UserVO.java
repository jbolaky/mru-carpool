package com.javaid.bolaky.carpool.service.vo;

import java.io.Serializable;

import com.javaid.bolaky.carpool.service.hibernate.constraint.ConfirmEmail;
import com.javaid.bolaky.carpool.service.hibernate.constraint.ConfirmPassword;

@ConfirmPassword
@ConfirmEmail
public class UserVO implements Serializable {

	private static final long serialVersionUID = 9103665130138957313L;

	private String username;

	private Integer ageGroup;

	private String firstname;

	private String lastname;

	private String password;

	private String confirmPassword;

	private String emailAddress;

	private String confirmEmailAddress;

	private Boolean carOwner;

	private Boolean validLicense;

	private String gender;

	private String countryCode;

	private String areaCode;

	private String districtCode;

	private String addressLine1;

	private String phoneNumber;

	private Boolean allowToReceiveUpdates;

	private Boolean shareCost;

	private Boolean shareDriving;

	public String getUsername() {
		return username;
	}

	public Integer getAgeGroup() {
		return ageGroup;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getConfirmEmailAddress() {
		return confirmEmailAddress;
	}

	public Boolean getCarOwner() {
		return carOwner;
	}

	public Boolean getValidLicense() {
		return validLicense;
	}

	public String getGender() {
		return gender;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Boolean getAllowToReceiveUpdates() {
		return allowToReceiveUpdates;
	}

	public Boolean getShareCost() {
		return shareCost;
	}

	public Boolean getShareDriving() {
		return shareDriving;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAgeGroup(Integer ageGroup) {
		this.ageGroup = ageGroup;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setConfirmEmailAddress(String confirmEmailAddress) {
		this.confirmEmailAddress = confirmEmailAddress;
	}

	public void setCarOwner(Boolean carOwner) {
		this.carOwner = carOwner;
	}

	public void setValidLicense(Boolean validLicense) {
		this.validLicense = validLicense;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAllowToReceiveUpdates(Boolean allowToReceiveUpdates) {
		this.allowToReceiveUpdates = allowToReceiveUpdates;
	}

	public void setShareCost(Boolean shareCost) {
		this.shareCost = shareCost;
	}

	public void setShareDriving(Boolean shareDriving) {
		this.shareDriving = shareDriving;
	}

}
