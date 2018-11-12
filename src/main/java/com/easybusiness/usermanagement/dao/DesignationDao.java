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

import com.easybusiness.usermanagement.entity.Designation;
import com.easybusiness.usermanagement.repository.DesignationRepository;


/*
 * DAO class for DESIGNATION table
 */

@Component
public class DesignationDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DesignationDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    DesignationRepository designationRepository;

    /*
     * fetching all datas from DESIGNATION table by calling findAll method
     */
    @Transactional(readOnly = true)
    public List<Designation> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Designation> designationList = new ArrayList<Designation>();
	for (Designation designation : designationRepository.findAll()) {
	    LOGGER.info("Designation : " + designation);
	    designationList.add(designation);

	}
	return designationList;

    }

    
    /*
     * fetching designation by desigName
     */
    @Transactional(readOnly = true)
    public Designation findByDesigName(String desigName) {
	for (Designation designation : designationRepository.findByDesig(desigName)) {
	    LOGGER.info("Designation : " + designation);
	}
	return designationRepository.findByDesig(desigName).get(0);
    }

    @Transactional(readOnly = true)
    public Optional<Designation> findDesignationById(Long id) {
	/*for (Designation designation : designationRepository.findById(id)) {
	    LOGGER.info("Designation : " + designation);
	}*/
	return designationRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDesignation(Designation designation) {
	designationRepository.save(designation);
	LOGGER.info("Designation added successfully " + designation.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDesignation(Long id) {
	designationRepository.delete(id);
	LOGGER.info("Designation with id " + id + " deleted successfully ");
    }

}
