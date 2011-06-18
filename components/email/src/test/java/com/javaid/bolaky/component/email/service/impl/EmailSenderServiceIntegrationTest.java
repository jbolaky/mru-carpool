package com.javaid.bolaky.component.email.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaid.bolaky.component.email.acl.commons.email.impl.CommonsEmailAclException;
import com.javaid.bolaky.component.email.service.api.EmailSenderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/email-default-context.xml" })
public class EmailSenderServiceIntegrationTest {

	@Resource(name = "email_components_DefaultEmailSenderService")
	private EmailSenderService emailSenderService;

	private String[] toEmailAddreses = { "gud_boy@live.com" };

	@Test
	public void testSendMailAfterRegistration() throws CommonsEmailAclException {
		assertTrue(emailSenderService.sendSimpleTextEmail("TestMail",
				"This is a test mail ... :-)", Arrays.asList(toEmailAddreses)));
	}
}
