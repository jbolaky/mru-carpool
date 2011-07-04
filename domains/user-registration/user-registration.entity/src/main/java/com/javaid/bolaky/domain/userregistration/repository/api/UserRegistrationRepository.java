package com.javaid.bolaky.domain.userregistration.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaid.bolaky.domain.userregistration.entity.Person;

public interface UserRegistrationRepository extends
		JpaRepository<Person, String> {

	@Query(value = "select p from Person p where p.username =:username or p.contactDetails.emailAddress=:emailAddress or p.username =:username and p.contactDetails.emailAddress=:emailAddress")
	Person findByUsernameAndEmailAddress(@Param("username") String username,
			@Param("emailAddress") String emailAddress);
}
