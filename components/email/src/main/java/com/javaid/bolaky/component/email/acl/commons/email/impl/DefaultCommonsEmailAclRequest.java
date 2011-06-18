package com.javaid.bolaky.component.email.acl.commons.email.impl;

import java.util.ArrayList;
import java.util.List;

import com.javaid.bolaky.component.email.acl.commons.email.api.CommonsEmailAclRequest;

public class DefaultCommonsEmailAclRequest implements CommonsEmailAclRequest {

	private String subjectOfMail;
	private String contentOfMail;
	private List<String> toEmailAddresses = new ArrayList<String>();

	
	public String getSubjectOfMail() {
		return subjectOfMail;
	}

	public String getContentOfMail() {
		return contentOfMail;
	}

	public List<String> getToEmailAddresses() {
		return toEmailAddresses;
	}

	public void setSubjectOfMail(String subjectOfMail) {
		this.subjectOfMail = subjectOfMail;
	}

	public void setContentOfMail(String contentOfMail) {
		this.contentOfMail = contentOfMail;
	}

	public void addToEmailAddress(String toEmailAddress) {
		toEmailAddresses.add(toEmailAddress);
	}

}
