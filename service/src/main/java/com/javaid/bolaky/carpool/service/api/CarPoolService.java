package com.javaid.bolaky.carpool.service.api;

import java.util.Set;

import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;
import com.javaid.bolaky.carpool.service.vo.ContactDriverVO;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

public interface CarPoolService {

	Set<CarPoolError> validate(UserVO userVO);

	Set<CarPoolError> validate(PoolRegistrationVO carPoolRegistrationVO);

	Boolean store(UserVO userVO);

	Boolean update(UserVO userVO);

	Boolean saveOrUpdate(PoolRegistrationVO poolRegistrationVO);

	Set<LocationVO> getAllCountries();

	Set<LocationVO> getAreas(Long countryId);

	Set<LocationVO> getDistricts(Long areaId);

	Boolean emailPassword(String firstname, String lastname, String password,
			String recipientEmailAddress) throws EmailAclException;

	UserVO findByUsernameAndEmailAddress(String username, String emailAddress);

	PoolRegistrationVO createCarpoolRegistrationVO(String username);

	PoolRegistrationVO findPoolRegistrationVO(Long poolId);

	void populateGenderAndUsername(PoolRegistrationVO poolRegistrationVO,
			String username);

	Set<PoolSearchResultVO> findPools(PoolSearchVO poolSearchVO);

	Set<PoolVO> findPools(String username);

	PoolVO findPool(Long poolId);

	Boolean sendRequestForPooling(ContactDriverVO contactDriverVO);
}
