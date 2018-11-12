package com.easybusiness.usermanagement.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.repository.DepartmentRepository;


/*
 * DAO class for DEPARTMENT table
 */
@Component
public class DepartmentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentRepository departmentRepository;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @PersistenceContext
    private EntityManager entityManager;

    
    /*
     * fetching all datas from DEPARTMENT table by calling findAll method
     */
    @Transactional(readOnly = true)
    public List<Department> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Department> departmentList = new ArrayList<Department>();
	for (Department department: departmentRepository.findAll()) {
	    LOGGER.info("Department : " + department);
	    departmentList.add(department);

	}
	return departmentList;

    }

    
    /*
     * fetching department from DEPARTMENT table by depatName by calling findByDeptName method
     */
    @Transactional(readOnly = true)
    public Department findByDepartmentName(String deptName) {
	for (Department department : departmentRepository.findByDeptName(deptName)) {
	    LOGGER.info("Department : " + department);
	}
	return departmentRepository.findByDeptName(deptName).get(0);
    }

    @Transactional(readOnly = true)
    public Optional<Department> findDepartmentById(Long id) {
	/*for (Department department : departmentRepository.findById(id)) {
	    LOGGER.info("Department : " + department);
	}*/
	return departmentRepository.findById(id);
    }
    
    /*
     * fething department by orgId from DEPARTMENT table by calling findByOrganization. findOrganizationById of
     * organizationDao is called to fetch the organization of which orgId will be used to fetch department.
     */
    @Transactional(readOnly = true)
    public List<Department> findDepartmentByOrgId(Long orgId) {
	Optional<Organization> organization=organizationDao.findOrganizationById(orgId);
	return departmentRepository.findByOrganization(organization);
    }

    
    /*
     * saving department to DEPARTMENT table of the database by calling addDepartment method
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addDepartment(Department department) {
//    	departmentRepository.save(department);
    	
	entityManager.merge(department);
    	
    	
	LOGGER.info("Department added successfully " + department.toString());
    }

    
    /*
     * deleting department from DEPARTMENT table 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDepartment(Long id) {
	departmentRepository.delete(id);
	LOGGER.info("Department with id " + id + " deleted successfully ");
    }

}
