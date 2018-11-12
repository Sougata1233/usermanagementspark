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

import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.repository.UserGroupRepository;

/*
 * DAO class for USER_GROUP_MASTER table 
 */

@Component
public class UserGroupDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserGroupDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Transactional(readOnly = true)
    public List<UserGroup> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserGroup> UserGroupList = new ArrayList<UserGroup>();
	for (UserGroup UserGroup : userGroupRepository.findAll()) {
	    LOGGER.info("UserGroup : " + UserGroup);
	    UserGroupList.add(UserGroup);

	}
	
	return UserGroupList;

    }

    @Transactional(readOnly = true)
    public UserGroup findByUserGroupName(String UserGroupName) {
	for (UserGroup UserGroup : userGroupRepository.findByUserGroupName(UserGroupName)) {
	    LOGGER.info("UserGroup : " + UserGroup);
	}
	return userGroupRepository.findByUserGroupName(UserGroupName).get(0);
    }

    @Transactional(readOnly = true)
    public Optional<UserGroup> findUserGroupById(Long id) {
	/*for (UserGroup UserGroup : userGroupRepository.findById(id)) {
	    LOGGER.info("UserGroup : " + UserGroup);
	}*/
	return userGroupRepository.findById(id);
    }

  

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserGroup(UserGroup UserGroup) {
	userGroupRepository.save(UserGroup);
	LOGGER.info("UserGroup added successfully " + UserGroup.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserGroup(Long UserGroupId) {
	userGroupRepository.delete(UserGroupId);
	LOGGER.info("UserGroup with id " + UserGroupId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserGroup(UserGroup userGroup) {
    	userGroupRepository.save(userGroupRepository.findOne(userGroup.getId()));
    }

}
