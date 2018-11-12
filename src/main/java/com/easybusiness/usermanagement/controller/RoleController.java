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

import com.easybusiness.usermanagement.DTO.RoleDTO;
import com.easybusiness.usermanagement.services.serviceimpl.RoleServiceImpl;

/*
 * Service and RestController class for ROLE_DETAILS table
 */
@RestController
@RequestMapping("/easybusiness/role/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class RoleController {
	
	@Autowired
	RoleServiceImpl roleService;
	
	@GetMapping("getRoleByName/{roleName}")
	public RoleDTO getRoleByName(@PathVariable("roleName") String roleName) {
		return roleService.getRoleByName(roleName);
	}
	
	@PostMapping("addRole")
	public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleModel){
		return roleService.addRole(roleModel);
	}
	
	@GetMapping("getAllRoles")
	public List<RoleDTO> getAllRoles() throws Exception {
		return roleService.getAllRoles();
	}
	
	@GetMapping("getRoleById/{roleId}")
	public RoleDTO getRoleById(@PathVariable("roleId") Long roleId) {
		return roleService.getRoleById(roleId);
	}
	
	@DeleteMapping("deleteRole/{roleId}")
	public ResponseEntity<RoleDTO> deleteRole(@PathVariable("roleId") Long roleId){
		return roleService.deleteRole(roleId);
	}

}
