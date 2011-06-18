package com.javaid.bolaky.component.email.service.api;

import java.util.Collection;

import com.javaid.bolaky.component.email.acl.commons.email.impl.CommonsEmailAclException;

public interface EmailSenderService {

	Boolean sendSimpleTextEmail(String subjectOfEmail, String messageInEmail,
			Collection<String> toEmailAddresses)
			throws CommonsEmailAclException;
}
