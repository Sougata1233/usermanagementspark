package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.Role;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserRoleMap;
import com.easybusiness.usermanagement.repository.UserRoleMapRepository;

/*
 * DAO class for USER_ROLE_MAP_MASTER table 
 */

@Component
public class UserRoleMapDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleMapDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserRoleMapRepository userRoleMapRepository;

    @Transactional(readOnly = true)
    public List<UserRoleMap> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserRoleMap> userRoleMapList = new ArrayList<UserRoleMap>();
	for (UserRoleMap userRoleMap : userRoleMapRepository.findAll()) {
	    LOGGER.info("UserRoleMap : " + userRoleMap);
	    userRoleMapList.add(userRoleMap);

	}
	return userRoleMapList;

    }

    @Transactional(readOnly = true)
    public List<UserRoleMap> findByUser(User user) {
	for (UserRoleMap userRoleMap : userRoleMapRepository.findByUser(user)) {
	    LOGGER.info("UserRoleMap : " + userRoleMap);
	}
	return userRoleMapRepository.findByUser(user);
    }
    
    @Transactional(readOnly = true)
    public List<UserRoleMap> findByRole(Role role) {
	for (UserRoleMap userRoleMap : userRoleMapRepository.findByRole(role)) {
	    LOGGER.info("UserRoleMap : " + userRoleMap);
	}
	return userRoleMapRepository.findByRole(role);
    }


    @Transactional(readOnly = true)
    public Optional<UserRoleMap> findUserRoleMapById(Long id) {
	/*for (UserRoleMap userRoleMap : userRoleMapRepository.findById(id)) {
	    LOGGER.info("UserRoleMap : " + userRoleMap);
	}*/
	return userRoleMapRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserRoleMap(UserRoleMap userRoleMap) {
	userRoleMapRepository.save(userRoleMap);
	LOGGER.info("UserRoleMap added successfully " + userRoleMap.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserRoleMap(Long userRoleMapId) {
	userRoleMapRepository.delete(userRoleMapId);
	LOGGER.info("UserRoleMap with id " + userRoleMapId + " deleted successfully ");
    }

}
