package com.javaid.bolaky.component.email.acl.commons.email.api;

import java.util.Collection;

public interface CommonsEmailAclRequest {

	String getSubjectOfMail();

	String getContentOfMail();

	Collection<String> getToEmailAddresses();
}
