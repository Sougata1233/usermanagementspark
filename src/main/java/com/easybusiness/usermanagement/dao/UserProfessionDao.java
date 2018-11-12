package com.easybusiness.usermanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserProfession;
import com.easybusiness.usermanagement.repository.UserProfessionRepository;

/*
 * DAO class for USER_PROFESSION table
 */

@Component
public class UserProfessionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfessionDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserProfessionRepository userProfessionRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserProfession(UserProfession userProfession) {
	userProfessionRepository.save(userProfession);
	LOGGER.info("User Profession added successfully " + userProfession.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserProfession> getUserProfessionByUser(Long userId) {
	return userProfessionRepository.findByUser(userId);

    }
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserProfession(UserProfession userProfession) {
	userProfessionRepository.save(userProfessionRepository.findOne(userProfession.getId()));
	LOGGER.info("User Profession updated successfully " + userProfession.toString());
    }
    
    @Transactional
    public UserProfession getProfessionByUserId(Long user) {
    	return userProfessionRepository.findByUserid(user);
    }
    
    @Transactional
    public UserProfession getProfessionById(long id) {
    	return userProfessionRepository.findOne(id);
    }
    
    
    /*@Transactional
    public List<UserProfession> getUserprofessionOrderedAndGrouped(Long userId){
    	return userProfessionRepository.findOrderByIdGroupById(userId);
    }*/

}
