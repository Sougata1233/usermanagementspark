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
import com.easybusiness.usermanagement.repository.BankRepository;


/*
 * DAO class for BANK_MASTER table
 */
@Component
public class BankDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BankRepository bankRepository;

    /*
     * findAll method for BANK_MASTER table
     */
    @Transactional(readOnly = true)
    public List<Bank> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Bank> bankList = new ArrayList<Bank>();
	for (Bank bank : bankRepository.findAll()) {
	    LOGGER.info("Bank : " + bank);
	    bankList.add(bank);

	}
	return bankList;

    }

    
    /*
     * finding bank by bank name from BANK_MASTER table by calling findByBankName method
     */
    @Transactional(readOnly = true)
    public List<Bank> findByBankName(String bankName) {
	for (Bank bank : bankRepository.findByBankName(bankName)) {
	    LOGGER.info("Bank : " + bank);
	}
	return bankRepository.findByBankName(bankName);
    }

    
    /*
     * finding bank by bankid from BANK_MASTER table by calling findBankById method
     */
    @Transactional(readOnly = true)
    public List<Bank> findBankById(Long id) {
	/*for (Bank bank : bankRepository.findById(id)) {
	    LOGGER.info("Bank : " + bank);
	}*/
	return bankRepository.findById(id);
    }

    
    /*
     * saving bank to database for BANK_MASTER table by calling addBank method of bankrepository
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBank(Bank bank) {
	bankRepository.save(bank);
	LOGGER.info("Bank added successfully " + bank.toString());
    }

    
    /*
     * deleting bank by finding it through bankid and calling delete method 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBank(Long bankId) {
	bankRepository.delete(bankId);
	LOGGER.info("Bank with id " + bankId + " deleted successfully ");
    }

}
