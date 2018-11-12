package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.DTO.UserLoginDetailsDTO;
import com.easybusiness.usermanagement.entity.UserLoginDetails;
import com.easybusiness.usermanagement.repository.UserLoginDetailsRepository;

/*
 * DAO class for USER_LOGIN_DETAILS table which stores login details of users
 */

@Component
public class UserLoginDetailsDao {

	@Autowired
    DataSource dataSource;

	@Autowired
	UserLoginDetailsRepository userLoginRepository;
	
	@Transactional(readOnly = true)
	public UserLoginDetails getLoginDetailsByLoginToken(String loginToken) throws Exception{
		/*List<UserLoginDetails> loginDetails = new ArrayList<>();
		for(UserLoginDetails loginDetail : userLoginRepository.findByLoginToken(loginToken)) {
			loginDetails.add(loginDetail);
		}
		*/
		return userLoginRepository.findByLoginToken(loginToken);
	}
	
	@Transactional
	public List<UserLoginDetails> getLoginDetailsByUserId(String userLoginId) throws Exception{
		return userLoginRepository.findByUserLoginId(userLoginId);
	}
	
	@Transactional
	public void saveLoginDetails(UserLoginDetails login) {
		userLoginRepository.save(login);
	}
	
	@Transactional
	public void updateLoginDetails(String loginToken) {
		userLoginRepository.save(userLoginRepository.findOne(Long.valueOf(loginToken)));
	}
	
}
