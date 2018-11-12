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

import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.services.serviceimpl.DesignationServiceImpl;

/*
 * Service and RestController class for DESIGNATION
 */
@RestController
@RequestMapping("/easybusiness/designation/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class DesignationController {

	@Autowired
	DesignationServiceImpl desigService;
	
	@GetMapping("getDesignationByName/{desigName}")
	public DesignationDto getDesignationByName(@PathVariable("desigName") String desigName) {
		return desigService.getDesignationByName(desigName);
	}
	
	@GetMapping("getAllDesignations")
	public List<DesignationDto> getAllDesignations() throws Exception{
		return desigService.getAllDesignations();
	}
	
	@PostMapping("addDesignation")
	public ResponseEntity<DesignationDto> addDesignation(@RequestBody DesignationDto desigModel){
		return desigService.addDesignation(desigModel);
	}
	
	@GetMapping("getDesignationById/{desigId}")
	public DesignationDto getDesignationById(@PathVariable("desigId") Long desigId) {
		return desigService.getDesignationById(desigId);
	}
	
	@DeleteMapping("deleteDesignation/{desigId}")
	public ResponseEntity<DesignationDto> deleteDesignation(@PathVariable("desigId") Long desigId){
		return desigService.deleteDesignation(desigId);
	}
	
}
