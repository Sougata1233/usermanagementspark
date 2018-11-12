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

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMenu;
import com.easybusiness.usermanagement.repository.UserGroupMenuRepository;

/*
 * DAO class for USER_GRP_MENU_MASTER table
 */

@Component
public class UserGroupMenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserGroupMenuDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserGroupMenuRepository userGroupMenuRepository;

    @Transactional(readOnly = true)
    public List<UserGroupMenu> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserGroupMenu> UserGroupMenuList = new ArrayList<UserGroupMenu>();
	for (UserGroupMenu userGroupMenu : userGroupMenuRepository.findAll()) {
	    LOGGER.info("UserGroupMenu : " + userGroupMenu);
	    UserGroupMenuList.add(userGroupMenu);

	}
	return UserGroupMenuList;

    }

    @Transactional(readOnly = true)
    public Optional<UserGroupMenu> findUserGroupMenuById(Long id) {
	/*for (UserGroupMenu userGroupMenu : userGroupMenuRepository.findById(id)) {
	    LOGGER.info("UserGroupMenu : " + userGroupMenu);
	}*/
	return userGroupMenuRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<UserGroupMenu> findUserGroupMenuByUserGroup(UserGroup userGroup) {
	for (UserGroupMenu userGroupMenu : userGroupMenuRepository.findByUserGroup(userGroup)) {
	    LOGGER.info("UserGroupMenu : " + userGroupMenu);
	}
	return userGroupMenuRepository.findByUserGroup(userGroup);
	
    }
    
    @Transactional(readOnly = true)
    public List<UserGroupMenu> findUserGroupMenuByMenu(Menu menu) {
	for (UserGroupMenu userGroupMenu : userGroupMenuRepository.findByMenuItem(menu)) {
	    LOGGER.info("UserGroupMenu : " + userGroupMenu);
	}
	return userGroupMenuRepository.findByMenuItem(menu);
	
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserGroupMenu addUserGroupMenu(UserGroupMenu userGroupMenu) {
	if (userGroupMenuRepository.findByUserGroupAndMenuItem(userGroupMenu.getUserGroup(),userGroupMenu.getMenuItem()).size()>0){
	    userGroupMenu.setId(userGroupMenuRepository.findByUserGroupAndMenuItem(userGroupMenu.getUserGroup(),userGroupMenu.getMenuItem()).get(0).getId());
	}
	return userGroupMenuRepository.save(userGroupMenu);
//	LOGGER.info("UserGroupMenu added successfully " + userGroupMenu.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserGroupMenu(Long userGroupMenuId) {
	userGroupMenuRepository.delete(userGroupMenuId);
	LOGGER.info("UserGroupMenu with id " + userGroupMenuId + " deleted successfully ");
    }

}
