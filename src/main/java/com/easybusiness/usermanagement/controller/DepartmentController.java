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

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.services.serviceimpl.DepartmentServiceImpl;

/*
 * Service and RestController class for DEPARTMENT table
 */
@RestController
@RequestMapping("/easybusiness/department/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl deptService;
	
	@GetMapping("getDepartmentByName/{deptName}")
	public DepartmentDto getDepartmentByName(@PathVariable("deptName") String deptName) {
		return deptService.getDepartmentByName(deptName);
	}
	
	@PostMapping("addDepartment")
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto deptModel){
		return deptService.addDepartment(deptModel);
	}
	
	@GetMapping("getAllDepartments")
	public List<DepartmentDto> getAllDepartments() throws Exception {
		return deptService.getAllDepartments();
	}
	
	@GetMapping("getDepartmentById/{deptId}")
	public DepartmentDto getDepartmentById(@PathVariable("deptId") Long deptId) {
		return deptService.getDepartmentById(deptId);
	}
	
	@GetMapping("getAllDepartmentsByOrganization/{orgId}")
	public List<DepartmentDto> getAllDepartmentsByOrganization(@PathVariable("orgId") Long orgId) 
																		throws Exception{
		return deptService.getAllDepartmentsByOrganization(orgId);
	}
	
	@DeleteMapping("deleteDepartment/{deptId}")
	public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable("deptId") Long deptId){
		return deptService.deleteDepartment(deptId);
	}
	

}
