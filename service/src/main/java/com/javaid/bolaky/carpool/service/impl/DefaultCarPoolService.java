package com.javaid.bolaky.carpool.service.impl;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaid.bolaky.carpool.service.acl.email.api.EmailAcl;
import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;
import com.javaid.bolaky.carpool.service.acl.location.api.LocationAcl;
import com.javaid.bolaky.carpool.service.acl.pools.api.PoolsAcl;
import com.javaid.bolaky.carpool.service.acl.userregistration.api.UserRegistrationAcl;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

@Service("carPoolService")
public class DefaultCarPoolService implements CarPoolService {

	@Resource(name = "carpool_service_DefaultUserRegistrationAcl")
	private UserRegistrationAcl userRegistrationAcl;

	@Resource(name = "carpool_service_DefaultEmailAcl")
	private EmailAcl emailAcl;

	@Resource(name = "pools_service_DefaultPoolsAcl")
	private PoolsAcl poolsAcl;

	private LocationAcl locationAcl;

	public Set<CarPoolError> validate(UserVO userVO) {

		Set<CarPoolError> carPoolErrorCodes = userRegistrationAcl
				.validate(userVO);

		return carPoolErrorCodes;
	}

	public Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO) {
		return poolsAcl.validate(carPoolRegistrationVO);
	}

	public Boolean store(UserVO userVO) {

		return userRegistrationAcl.store(userVO);
	}

	@Transactional
	public Boolean register(PoolRegistrationVO poolRegistrationVO) {

		return poolsAcl.register(poolRegistrationVO);
	}

	@Transactional
	public void populateGenderAndUsername(
			PoolRegistrationVO poolRegistrationVO, String username) {

		UserVO userVO = userRegistrationAcl.findByUsernameAndEmailAddress(
				username, null);
		poolRegistrationVO.setUsername(userVO.getUsername());
		poolRegistrationVO.setGender(userVO.getGender());
	}

	public Set<LocationVO> getAllCountries() {

		return locationAcl.getAllCountries();
	}

	public Boolean emailPassword(String firstname, String lastname,
			String password, String recipientEmailAddress)
			throws EmailAclException {

		String[] emailAddresses = { recipientEmailAddress };
		String subjectOfEmail = "The Car Pool - Forgot Password‏";
		String messageInEmail = "Hi " + firstname + " " + lastname
				+ ",/nHere is your account password:/n" + password
				+ "/nThank you,/nTheCarPool Team";

		return emailAcl.sendEmail(subjectOfEmail, messageInEmail,
				Arrays.asList(emailAddresses));
	}

	public UserVO findByUsernameAndEmailAddress(String username,
			String emailAddress) {

		return userRegistrationAcl.findByUsernameAndEmailAddress(username,
				emailAddress);
	}

	public PoolRegistrationVO createCarpoolRegistrationVO(String username) {
		return new PoolRegistrationVO(username);
	}

	public Set<PoolSearchResultVO> findPools(PoolSearchVO poolSearchVO) {
		return poolsAcl.findAvailablePools(poolSearchVO);
	}

	public PoolVO findPool(Long poolId) {
		return poolsAcl.findPool(poolId);
	}

}
