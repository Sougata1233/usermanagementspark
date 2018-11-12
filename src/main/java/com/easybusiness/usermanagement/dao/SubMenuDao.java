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
import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.repository.SubMenuRepository;

/*
 * DAO class for SUBMENU_MASTER table
 */

@Component
public class SubMenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubMenuDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    SubMenuRepository subMenuRepository;

    @Transactional(readOnly = true)
    public List<SubMenu> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<SubMenu> subMenuList = new ArrayList<SubMenu>();
	for (SubMenu subMenu : subMenuRepository.findAll()) {
	    LOGGER.info("SubMenu : " + subMenu);
	    subMenuList.add(subMenu);

	}
	return subMenuList;

    }

    @Transactional(readOnly = true)
    public List<SubMenu> findByMenu(Menu menu) {
	for (SubMenu subMenu : subMenuRepository.findByMenu(menu)) {
	    LOGGER.info("SubMenu : " + subMenu);
	}
	return subMenuRepository.findByMenu(menu);
    }

    @Transactional(readOnly = true)
    public Optional<SubMenu> findSubMenuById(Long id) {
	/*for (SubMenu subMenu : subMenuRepository.findById(id)) {
	    LOGGER.info("SubMenu : " + subMenu);
	}*/
	return subMenuRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addSubMenu(SubMenu subMenu) {
	subMenuRepository.save(subMenu);
	LOGGER.info("SubMenu added successfully " + subMenu.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSubMenu(Long subMenuId) {
	subMenuRepository.delete(subMenuId);
	LOGGER.info("SubMenu with id " + subMenuId + " deleted successfully ");
    }
    
    @Transactional
    public void updateSubMenu(SubMenu subMenu) {
    	subMenuRepository.save(subMenu);
    }

}
