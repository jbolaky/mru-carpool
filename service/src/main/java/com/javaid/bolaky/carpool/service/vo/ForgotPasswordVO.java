package com.javaid.bolaky.carpool.service.vo;

import org.hibernate.validator.constraints.Email;

import com.javaid.bolaky.carpool.service.hibernate.constraint.ForgotPasswordAttributeCheck;

@ForgotPasswordAttributeCheck
public class ForgotPasswordVO {

	private String username;
	
	@Email(message="S91")
	private String emailAddress;

	public String getUsername() {
		return username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
