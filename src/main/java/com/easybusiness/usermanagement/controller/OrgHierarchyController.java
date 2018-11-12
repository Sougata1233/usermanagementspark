package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.ParentOrgDTO;
import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;
import com.easybusiness.usermanagement.services.serviceimpl.OrgHierarcyServiceImpl;

/*
 * Service and RestController class for UserHierarchy
 */
@RestController
@RequestMapping("/easybusiness/orghierarcy/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class OrgHierarchyController {
	
	@Autowired 
	OrgHierarcyServiceImpl orghierarchyService;
	
	@GetMapping("getByOrgHierarcyId/{hierarcyId}")
	public ResponseEntity<UserHierarcyDTO> getHierarcyById(@PathVariable("hierarcyId") Long hierarcyId){
		return orghierarchyService.getHierarcyById(hierarcyId);
	}
	
	@PostMapping("addOrgHierarcy")
	public UserHierarcyDTO persistHierarcy(@RequestBody UserHierarcyDTO hierarcy) {
		return orghierarchyService.persistHierarcy(hierarcy);
	}
	
	@GetMapping("getAllOrgHierarcy")
	public List<UserHierarcyDTO> populateHierarcyList(){
		return orghierarchyService.populateHierarcyList();
	}
	
	@DeleteMapping("deleteOrgHierarcy/{hierarcyId}")
	public void destroyHierarcy(@PathVariable("hierarcyId") long hierarcyId) {
		orghierarchyService.destroyHierarcy(hierarcyId);
	}
	
	@PutMapping("updateOrgHierarcy/{hierarcyId}")
	public UserHierarcyDTO updateHierarcy(@PathVariable("hierarcyId") long hierarcyId, @RequestBody UserHierarcyDTO hierarchyDTO) {
		return orghierarchyService.updateHierarcy(hierarcyId, hierarchyDTO);
	}
	
	@GetMapping("getGroupHeadOrgHierarchy")
	public ParentOrgDTO groupHead() {
		return orghierarchyService.groupHead();
	}

}
