package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.UserHierarchy;
import com.easybusiness.usermanagement.repository.UserHierarcyRepository;

/*
 * DAO class for USER_HIERARCY table. This class generates tree structure of organization structure
 */

@Component
public class UserHierarcyDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    DataSource dataSource;
    
    @Autowired
    UserHierarcyRepository hierarcyRepository;
    
    @Transactional
    public List<UserHierarchy> getAllHierarcy(){
    	List<UserHierarchy> hierarcyEmp = new ArrayList<>();
    	for(UserHierarchy hierarchy : hierarcyRepository.findAll()) {
    		hierarcyEmp.add(hierarchy);
    	}
    	
    	return hierarcyEmp;
    }
    
    @Transactional
    public UserHierarchy getHierarchyById(long id){
    	return hierarcyRepository.findByHierarcyId(id);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByOrgHead(long orgHead){
    	return hierarcyRepository.findHierarcyByOrgHead(orgHead);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByGroupHead(long groupHead){
    	return hierarcyRepository.findHierarcyByGroupHead(groupHead);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByHrManager(long hrManager){
    	return hierarcyRepository.findHierarchyByHrManager(hrManager);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByPriSupervisor(long priSupervisor){
    	return hierarcyRepository.findHierarchyBypriSupervisor(priSupervisor);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByPrjSupervisor(long prjSupervisor){
    	return hierarcyRepository.findHierarchyByPrjSupervisor(prjSupervisor);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByUser(long id){
    	return hierarcyRepository.findHierarchyByUserId(id);
    }
    
    @Transactional
    public UserHierarchy getHierarchyById1(long id){
    	return hierarcyRepository.findOne(id);
    }
    
    @Transactional
    public void deleteHierarcy(long id) {
    	hierarcyRepository.delete(id);
    }
    
    @Transactional
    public void saveHierarcy(UserHierarchy hierarcy) {
    	hierarcyRepository.save(hierarcy);
    }
    
    @Transactional
    public void updateHierarcy(UserHierarcyDTO hierarcyDTO) {
    	hierarcyRepository.save(hierarcyRepository.findOne(hierarcyDTO.getHierarcyId()));
    }
    
    @Transactional
    public void update(UserHierarchy hierarcyDTO) {
    	hierarcyRepository.save(hierarcyDTO);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByParentOrgId(long id){
    	return hierarcyRepository.findByParentOrgId(id);
    }
    
    @Transactional
    public List<UserHierarchy> getHierarchyByOrgId(long id){
    	return hierarcyRepository.findByOrgId(id);
    }
	
}
