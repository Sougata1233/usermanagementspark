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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.services.serviceimpl.OrganizationServiceImpl;

/*
 * Service and RestController for ORGANIZATION table
 */
@RestController
@RequestMapping("/easybusiness/organization/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class OrganizationController {
	
	@Autowired
	OrganizationServiceImpl orgService;
	
	@GetMapping("getOrganizationByName/{orgName}")
	public OrganizationDto getOrganizationByName(@PathVariable("orgName") String orgName) {
		return orgService.getOrganizationByName(orgName);
	}
	
	@PostMapping("addOrganization")
	public ResponseEntity<OrganizationDto> addOrganization(@RequestBody OrganizationDto orgModel){
		return orgService.addOrganization(orgModel);
	}
	
	@GetMapping("getAllOrganizations")
	public List<OrganizationDto> getAllOrganizations() throws Exception{
		return orgService.getAllOrganizations();
	}
	
	@GetMapping("getOrganizationById/{orgId}")
	public OrganizationDto getOrganizationById(@PathVariable("orgId") Long orgId) {
		return orgService.getOrganizationById(orgId);
	}
	
	@DeleteMapping("deleteOrganization/{orgId}")
	public ResponseEntity<OrganizationDto> deleteOrganization(@PathVariable("orgId") Long orgId){
		return orgService.deleteOrganization(orgId);
	}

}
