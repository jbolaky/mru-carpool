package com.javaid.bolaky.component.email.acl.commons.email.impl;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.javaid.bolaky.component.email.MailConfig;
import com.javaid.bolaky.component.email.acl.commons.email.api.CommonsEmailAclRequest;

public class CommonsEmailAclTranslator {

	public static Email convertToApacheCommonsEmail(MailConfig mailConfig)
			throws EmailException {

		Email email = null;

		if (mailConfig != null) {

			email = new SimpleEmail();
			email.setAuthentication(mailConfig.getUsername(),
					mailConfig.getPassword());
			email.setFrom(mailConfig.getFromEmailAddress());
			email.setHostName(mailConfig.getHostName());
			email.setSmtpPort(mailConfig.getSmtpPort());
			email.setTLS(mailConfig.getTls());
		}

		return email;
	}

	public static Email convertToEmail(Email email,
			CommonsEmailAclRequest commonsEmailAclRequest)
			throws EmailException {

		if (email != null && commonsEmailAclRequest != null) {

			email.setSubject(commonsEmailAclRequest.getSubjectOfMail());
			email.setMsg(commonsEmailAclRequest.getContentOfMail());

			if (commonsEmailAclRequest.getToEmailAddresses() != null
					&& !commonsEmailAclRequest.getToEmailAddresses().isEmpty()) {

				for (String toEmailAddress : commonsEmailAclRequest
						.getToEmailAddresses()) {
					email.addTo(toEmailAddress);
				}
			}
		}

		return email;
	}
}
