package com.javaid.bolaky.domain.userregistration.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.hibernate.validator.constraints.Email;

import com.javaid.bolaky.domain.userregistration.hibernate.group.AddressDataRule;
import com.javaid.bolaky.domain.userregistration.hibernate.group.MandatoryDataRules;

@Embeddable
public class ContactDetails {

	@Email(groups=MandatoryDataRules.class,message="UM7")
	@NotNull(groups=MandatoryDataRules.class,message="UM8")
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Valid
	@NotNull(groups=AddressDataRule.class,message="U40")
	@Size(min=1,groups=AddressDataRule.class,message="U45")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Address> addresses = new ListOrderedSet<Address>();

	@Transient
	private Person person;

	protected ContactDetails() {
		super();
	}

	protected ContactDetails(Person person) {
		super();
		this.person = person;
	}

	public String getEmailAddresse() {
		return emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean addAddress(Address address) {

		if (address != null) {
			address.setPerson(person);
		}

		return addresses.add(address);
	}

}
