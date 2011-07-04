package com.javaid.bolaky.carpool.service.acl.email.impl;

import java.util.Collection;

import javax.annotation.Resource;

import com.javaid.bolaky.carpool.service.acl.email.api.EmailAcl;
import com.javaid.bolaky.component.email.acl.commons.email.impl.CommonsEmailAclException;
import com.javaid.bolaky.component.email.service.api.EmailSenderService;

public class DefaultEmailAcl implements EmailAcl {

	@Resource(name="email_components_DefaultEmailSenderService")
	private EmailSenderService emailSenderService;

	public Boolean sendEmail(String subjectOfEmail, String messageInEmail,
			Collection<String> toEmailAddresses) throws EmailAclException {

		boolean emailSuccessfullySent = false;

		try {

			emailSuccessfullySent = emailSenderService.sendSimpleTextEmail(
					subjectOfEmail, messageInEmail, toEmailAddresses);

		} catch (CommonsEmailAclException commonsEmailAclException) {
			throw new EmailAclException(commonsEmailAclException);
		}

		return emailSuccessfullySent;
	}
}
