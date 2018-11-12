package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.repository.MenuRepository;

/*
 * DAO class for MENU_MASTER table
 */

@Component
public class MenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<Menu> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Menu> menuList = new ArrayList<Menu>();
	for (Menu menu : menuRepository.findAll()) {
	    LOGGER.info("Menu : " + menu);
	    menuList.add(menu);

	}
	return menuList;

    }

    @Transactional(readOnly = true)
    public Menu findByMenuName(String menuName) {
	for (Menu menu : menuRepository.findByMenuName(menuName)) {
	    LOGGER.info("Menu : " + menu);
	}
	return menuRepository.findByMenuName(menuName).get(0);
    }

    @Transactional(readOnly = true)
    public Optional<Menu> findMenuById(Long id) {
	/*for (Menu menu : menuRepository.findById(id)) {
	    LOGGER.info("Menu : " + menu);
	}*/
	return menuRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public void findByMenuNameStream(String menuName) {
	try (Stream<Menu> stream = menuRepository.findByMenuNameReturnStream(menuName)) {
	    stream.forEach(x -> {
		LOGGER.info("Menu : " + x);
	    });
	}

    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void addMenu(Menu menu)
    {
	menuRepository.save(menu);
	LOGGER.info("menu added successfully " +menu.toString());
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void deleteMenu(Long menuId)
    {
	menuRepository.delete(menuId);
	LOGGER.info("menu with id " +menuId+" deleted successfully " );
    }
    
    @Transactional
    public void updateMenu(Menu menu) {
    	
    	menuRepository.save(menu);
    	LOGGER.info("Menu updated successfully "+ menu.toString());
    }

}
