package com.javaid.bolaky.domain.pools.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.javaid.bolaky.domain.jpa.entity.AbstractTimestampUsernameEntity;

@Entity
@Table(name = "PASSENGER_REQUEST_INFO")
@TypeDefs({ @TypeDef(name = "hibernate_persistentDateTime", typeClass = org.joda.time.contrib.hibernate.PersistentDateTime.class) })
public class PassengerRequestInfo extends AbstractTimestampUsernameEntity {

	private static final long serialVersionUID = 4063044577770983493L;

	@Id
	@Column(name = "PASSENGER_REQUEST_INFO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long passengerRequestInfoId;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "ENQUIRY_DETAILS")
	private String enquiryDetails;

	@JoinColumn(name = "USERNAME")
	@ManyToOne(cascade = CascadeType.ALL)
	private Passenger passenger;

	public Long getPassengerRequestInfoId() {
		return passengerRequestInfoId;
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

	public Passenger getPassenger() {
		return passenger;
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

	void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
