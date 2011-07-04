package com.javaid.bolaky.carpool.service.acl.email.api;

import java.util.Collection;

import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;

public interface EmailAcl {

	Boolean sendEmail(String subjectOfEmail, String messageInEmail,
			Collection<String> toEmailAddresses) throws EmailAclException;
}
