package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.SubMenuUrl;
import com.easybusiness.usermanagement.repository.SubMenuUrlRepository;

/*
 * DAO class for SUBMENU_URL_MAP table
 */

@Component
public class SubMenuUrlDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubMenuUrlDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    SubMenuUrlRepository subMenuUrlRepository;

    @Transactional(readOnly = true)
    public List<SubMenuUrl> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<SubMenuUrl> subMenuList = new ArrayList<SubMenuUrl>();
	for (SubMenuUrl subMenu : subMenuUrlRepository.findAll()) {
	    LOGGER.info("SubMenuUrl : " + subMenu);
	    subMenuList.add(subMenu);

	}
	return subMenuList;

    }

    @Transactional(readOnly = true)
    public SubMenuUrl findBySubMenu(SubMenu subMenu) {
	for (SubMenuUrl subMenuUrl : subMenuUrlRepository.findBySubMenu(subMenu)) {
	    LOGGER.info("SubMenuUrl : " + subMenuUrl);
	}
	return subMenuUrlRepository.findBySubMenu(subMenu).get(0);
    }

    @Transactional(readOnly = true)
    public Optional<SubMenuUrl> findSubMenuUrlById(Long id) {
	/*for (SubMenuUrl subMenu : subMenuUrlRepository.findById(id)) {
	    LOGGER.info("SubMenuUrl : " + subMenu);
	}*/
	return subMenuUrlRepository.findById(id);
    }

}
