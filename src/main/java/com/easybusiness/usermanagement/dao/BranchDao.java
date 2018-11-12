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
import com.easybusiness.usermanagement.repository.BranchRepository;


/*
 * DAO class for BRANCH_MASTER table
 */
@Component
public class BranchDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BranchRepository branchRepository;

    /*
     * fetching all datas of BRANCH_MASTER table by calling findall method
     */
    @Transactional(readOnly = true)
    public List<Branch> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Branch> branchList = new ArrayList<Branch>();
	for (Branch branch : branchRepository.findAll()) {
	    LOGGER.info("Branch : " + branch);
	    branchList.add(branch);

	}
	return branchList;

    }

    
    /*
     * fetching data of BRANCH_MASTER by calling findByBank method
     */
    @Transactional(readOnly = true)
    public List<Branch> findByBank(Bank bank) {
	for (Branch branch : branchRepository.findByBank(bank)) {
	    LOGGER.info("Branch : " + branch);
	}
	return branchRepository.findByBank(bank);
    }

    
    /*
     * fetching data from BRANCH_MASTER table by calling findById method
     */
    @Transactional(readOnly = true)
    public List<Branch> findBranchById(Long id) {
	/*for (Branch Branch : branchRepository.findById(id)) {
	    LOGGER.info("Branch : " + Branch);
	}*/
	return branchRepository.findById(id);
    }

    
    /*
     * saving data to BRANCH_MASTER table of database by calling addBranch method of branchRFepository
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBranch(Branch branch) {
	branchRepository.save(branch);
	LOGGER.info("Branch added successfully " + branch.toString());
    }

    
    /*
     * deleting branch from BRANCH_MASTER table by calling deleteBranch method of branchRepository
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBranch(Long branchId) {
	branchRepository.delete(branchId);
	LOGGER.info("Branch with id " + branchId + " deleted successfully ");
    }
    
    
    /*
     * finding branch by bankId from BRANCH_MASTER table by calling findByBank method
     */
    @Transactional(readOnly = true)
    public List<Branch> findBranchByBankId(Bank bank) {
	return branchRepository.findByBank(bank);
    }

}
