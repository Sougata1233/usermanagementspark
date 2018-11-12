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
import com.easybusiness.usermanagement.entity.UserAcademics;
import com.easybusiness.usermanagement.repository.UserAcademicsRepository;

/*
 * DAO class for USER_EDUCATION table
 */

@Component
public class UserAcademicsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAcademicsDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserAcademicsRepository userAcademicsRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserAcademics(UserAcademics userAcademics) {
	userAcademicsRepository.save(userAcademics);
	LOGGER.info("User Academics added successfully " + userAcademics.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserAcademics> getUserAcademics(Long long1) {
	return (List<UserAcademics>) userAcademicsRepository.findByUser(long1);
	}
    
    @Transactional
    public UserAcademics getAcademicsById(long id) {
    	return userAcademicsRepository.findOne(id);
    }
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserAcademics(UserAcademics userAcademics) {
	userAcademicsRepository.save(userAcademicsRepository.findOne(userAcademics.getId()));
	LOGGER.info("User Academics updated successfully " + userAcademics.toString());
    }

}
