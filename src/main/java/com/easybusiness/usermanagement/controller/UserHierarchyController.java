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

import com.easybusiness.usermanagement.DTO.GroupHeadDTO;
import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserHierarcyServiceImpl;

/*
 * Service and RestController class for UserHierarchy
 */
@RestController
@RequestMapping("/easybusiness/userhierarcy/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserHierarchyController {
	
	@Autowired
	UserHierarcyServiceImpl hierarchyService;
	
	@GetMapping("getByHierarcyId/{hierarcyId}")
	public ResponseEntity<UserHierarcyDTO> getHierarcyById(@PathVariable("hierarcyId") Long hierarcyId){
		return hierarchyService.getHierarcyById(hierarcyId);
	}
	
	@PostMapping("addHierarcy")
	public UserHierarcyDTO persistHierarcy(@RequestBody UserHierarcyDTO hierarcy) {
		return hierarchyService.persistHierarcy(hierarcy);
	}
	
	@GetMapping("getAllHierarcy")
	public List<UserHierarcyDTO> populateHierarcyList(){
		return hierarchyService.populateHierarcyList();
	}
	
	@DeleteMapping("deleteHierarcy/{hierarcyId}")
	public void destroyHierarcy(@PathVariable("hierarcyId") long hierarcyId) {
		hierarchyService.destroyHierarcy(hierarcyId);
	}
	
	@PutMapping("updateHierarcy/{hierarcyId}")
	public UserHierarcyDTO updateHierarcy(@PathVariable("hierarcyId") long hierarcyId,
											@RequestBody UserHierarcyDTO hierarchyDTO) {
		return hierarchyService.updateHierarcy(hierarcyId, hierarchyDTO);
	}
	
	@GetMapping("getGroupHead")
	public GroupHeadDTO groupHead() {
		return hierarchyService.groupHead();
	}
	
	

}
