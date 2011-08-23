package com.javaid.bolaky.carpool.service.vo;

public class ContactDriverVO {

	private Long poolId;
	
	private String firstname;

	private String lastname;

	private String emailAddress;

	private String phoneNumber;

	private String enquiryDetails;

	public Long getPoolId() {
		return poolId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
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

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
