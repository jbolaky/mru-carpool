package com.javaid.bolaky.component.email.acl.commons.email.api;

import com.javaid.bolaky.component.email.acl.commons.email.impl.CommonsEmailAclException;

public interface CommonsEmailAcl {

	Boolean sendEmail(CommonsEmailAclRequest commonsEmailAclRequest)
			throws CommonsEmailAclException;
}
