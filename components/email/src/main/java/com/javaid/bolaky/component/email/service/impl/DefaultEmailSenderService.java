package com.javaid.bolaky.component.email.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import com.javaid.bolaky.component.email.acl.commons.email.api.CommonsEmailAcl;
import com.javaid.bolaky.component.email.acl.commons.email.impl.CommonsEmailAclException;
import com.javaid.bolaky.component.email.acl.commons.email.impl.DefaultCommonsEmailAclRequest;
import com.javaid.bolaky.component.email.service.api.EmailSenderService;

public class DefaultEmailSenderService implements EmailSenderService {

	@Resource(name = "email_components_DefaultCommonsEmailAcl")
	private CommonsEmailAcl commonsEmailAcl;

	public Boolean sendSimpleTextEmail(String subjectOfMail,
			String messageInMail, Collection<String> toEmailAddresses)
			throws CommonsEmailAclException {

		DefaultCommonsEmailAclRequest defaultCommonsEmailAclRequest = new DefaultCommonsEmailAclRequest();

		if (toEmailAddresses != null && !toEmailAddresses.isEmpty()) {

			for (String toEmailAddress : toEmailAddresses) {
				defaultCommonsEmailAclRequest.addToEmailAddress(toEmailAddress);
			}

			defaultCommonsEmailAclRequest.setContentOfMail(messageInMail);
			defaultCommonsEmailAclRequest.setSubjectOfMail(subjectOfMail);
		}

		return commonsEmailAcl.sendEmail(defaultCommonsEmailAclRequest);
	}
}
