package com.javaid.bolaky.domain.userregistration.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.userregistration.entity.enumerated.Role;
import com.javaid.bolaky.domain.userregistration.repository.api.SpringSecurityUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/default-user-registration-entity-context.xml",
		"classpath:/default-user-registration-datasource-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback=false)
@Transactional(propagation = Propagation.REQUIRED)
public class SpringSecurityUserRepositoryIntegrationTest {

	@Autowired
	private SpringSecurityUserRepository springSecurityUserRepository;

	@Test
	public void testSaveAndFindOne() {

		String username = Long.toString(RandomUtils.nextLong());
		String password = Long.toString(RandomUtils.nextLong());

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setActive(true);

		Authority authority = new Authority();
		authority.setRole(Role.ROLE_USER);

		user.addAuthority(authority);

		/*user = springSecurityUserRepository.save(user);

		User user2 = springSecurityUserRepository.findOne(username);
		assertThat(user2.getPassword(), is(password));*/
	}
}
