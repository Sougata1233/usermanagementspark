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

import com.easybusiness.usermanagement.entity.Bank;
import com.easybusiness.usermanagement.entity.Branch;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserBankMap;
import com.easybusiness.usermanagement.repository.UserBankMapRepository;

/*
 * DAO class for USER_BANK_MAP_MASTER table 
 */

@Component
public class UserBankMapDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBankMapDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserBankMapRepository userBankMapRepository;

    @Transactional(readOnly = true)
    public List<UserBankMap> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserBankMap> userBankMapList = new ArrayList<UserBankMap>();
	for (UserBankMap userBankMap : userBankMapRepository.findAll()) {
	    LOGGER.info("UserBankMap : " + userBankMap);
	    userBankMapList.add(userBankMap);

	}
	return userBankMapList;

    }

    @Transactional(readOnly = true)
    public List<UserBankMap> findByUser(User user) {
	for (UserBankMap userBankMap : userBankMapRepository.findByUser(user)) {
	    LOGGER.info("UserBankMap : " + userBankMap);
	}
	return userBankMapRepository.findByUser(user);
    }
    
    @Transactional(readOnly = true)
    public List<UserBankMap> findByBank(Bank bank) {
	for (UserBankMap userBankMap : userBankMapRepository.findByBank(bank)) {
	    LOGGER.info("UserBankMap : " + userBankMap);
	}
	return userBankMapRepository.findByBank(bank);
    }
    
    @Transactional(readOnly = true)
    public List<UserBankMap> findByBranch(Branch branch) {
	for (UserBankMap userBankMap : userBankMapRepository.findByBranch(branch)) {
	    LOGGER.info("UserBankMap : " + userBankMap);
	}
	return userBankMapRepository.findByBranch(branch);
    }


    @Transactional(readOnly = true)
    public Optional<UserBankMap> findUserBankMapById(Long id) {
	/*for (UserBankMap userBankMap : userBankMapRepository.findById(id)) {
	    LOGGER.info("UserBankMap : " + userBankMap);
	}*/
	return userBankMapRepository.findById(id);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserBankMap(UserBankMap userBankMap) {
	if(userBankMapRepository.findByUser(userBankMap.getUser()).size()>0)
	{
	    userBankMap.setId(userBankMapRepository.findByUser(userBankMap.getUser()).get(0).getId()); 
	}
	userBankMapRepository.save(userBankMap);
	LOGGER.info("UserBankMap added successfully " + userBankMap.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserBankMap(Long userBankMapId) {
	userBankMapRepository.delete(userBankMapId);
	LOGGER.info("UserBankMap with id " + userBankMapId + " deleted successfully ");
    }

}
