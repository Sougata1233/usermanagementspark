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

import com.easybusiness.usermanagement.entity.UserMenu;
import com.easybusiness.usermanagement.repository.UserMenuRepository;

/*
 * DAO class for USER_MENU_MAPPING table
 */

@Component
public class UserMenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMenuDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMenuRepository UserMenuRepository;

    @Transactional(readOnly = true)
    public List<UserMenu> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserMenu> UserMenuList = new ArrayList<UserMenu>();
	for (UserMenu userMenu : UserMenuRepository.findAll()) {
	    LOGGER.info("UserMenu : " + userMenu);
	    UserMenuList.add(userMenu);

	}
	return UserMenuList;

    }

    @Transactional(readOnly = true)
    public Optional<UserMenu> findUserMenuById(Long id) {
	/*for (UserMenu UserMenu : UserMenuRepository.findById(id)) {
	    LOGGER.info("UserMenu : " + UserMenu);
	}*/
	return UserMenuRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserMenu(UserMenu userMenu) {
	UserMenuRepository.save(userMenu);
	LOGGER.info("UserMenu added successfully " + userMenu.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserMenu(Long userMenuId) {
	UserMenuRepository.delete(userMenuId);
	LOGGER.info("UserMenu with id " + userMenuId + " deleted successfully ");
    }

}
