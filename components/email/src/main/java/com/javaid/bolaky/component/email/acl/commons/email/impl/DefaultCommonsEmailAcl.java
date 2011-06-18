package com.javaid.bolaky.component.email.acl.commons.email.impl;

import javax.annotation.Resource;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import com.javaid.bolaky.component.email.MailConfig;
import com.javaid.bolaky.component.email.acl.commons.email.api.CommonsEmailAcl;
import com.javaid.bolaky.component.email.acl.commons.email.api.CommonsEmailAclRequest;

public class DefaultCommonsEmailAcl implements CommonsEmailAcl {

	@Resource(name = "email_components_MailConfig")
	private MailConfig mailConfig;

	public Boolean sendEmail(CommonsEmailAclRequest commonsEmailAclRequest)
			throws CommonsEmailAclException {

		try {
			Email email = CommonsEmailAclTranslator
					.convertToApacheCommonsEmail(mailConfig);
			email = CommonsEmailAclTranslator.convertToEmail(email,
					commonsEmailAclRequest);
			email.send();
		} catch (EmailException e) {
			throw new CommonsEmailAclException(e);
		}

		return true;
	}
}
