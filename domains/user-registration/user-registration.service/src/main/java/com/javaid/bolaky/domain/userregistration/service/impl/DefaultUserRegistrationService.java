package com.javaid.bolaky.domain.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.domain.userregistration.entity.Authority;
import com.javaid.bolaky.domain.userregistration.entity.Person;
import com.javaid.bolaky.domain.userregistration.entity.User;
import com.javaid.bolaky.domain.userregistration.repository.api.SpringSecurityUserRepository;
import com.javaid.bolaky.domain.userregistration.repository.api.UserRegistrationRepository;
import com.javaid.bolaky.domain.userregistration.service.api.UserRegistrationService;

@Transactional(readOnly = true)
public class DefaultUserRegistrationService implements UserRegistrationService {

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	//@Autowired
	private SpringSecurityUserRepository securityUserRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public Person savePerson(Person person) {

		//User user = createUser(person);
		//user = securityUserRepository.save(user);

		return userRegistrationRepository.save(person);
	}

	public Person retrievePerson(String username) {
		return userRegistrationRepository.findOne(username);
	}

	public Person findByUsernameAndEmailAddress(String username,
			String emailAddress) {

		return userRegistrationRepository.findByUsernameAndEmailAddress(
				username, emailAddress);
	}

	private User createUser(Person person) {

		User user = null;

		if (person != null) {

			user = new User();
			user.setUsername(person.getUsername());
			user.setPassword(person.getPassword());
			user.setActive(person.isActive());

			Authority authority = new Authority();
			authority.setRole(person.getRole());

			user.addAuthority(authority);
		}

		return user;
	}
}
