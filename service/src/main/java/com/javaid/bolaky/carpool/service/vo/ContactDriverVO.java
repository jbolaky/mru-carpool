package com.javaid.bolaky.carpool.service.vo;

public class ContactDriverVO {

	private Long poolId;
	
	private String username;

	private String emailAddress;

	private String phoneNumber;

	private String enquiryDetails;

	public Long getPoolId() {
		return poolId;
	}

	public String getUsername() {
		return username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEnquiryDetails() {
		return enquiryDetails;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEnquiryDetails(String enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}

}
