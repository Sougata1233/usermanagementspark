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

import com.easybusiness.usermanagement.DTO.UserRoleMapDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserRoleMappingServiceImpl;

@RestController
@RequestMapping("/easybusiness/userrole/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserRoleMappingController {
	
	@Autowired
	UserRoleMappingServiceImpl userRoleMapService;
	
	@GetMapping("getRoleByUserId/{userid}")
	public List<UserRoleMapDTO> getUserRoleByUserId(@PathVariable("userid") Long userId){
		return userRoleMapService.getUserRoleByUserId(userId);
	}
	
	@GetMapping("getRoleByRoleId/{roleid}")
	public List<UserRoleMapDTO> getUserRoleByRoleId(@PathVariable("roleid") Long roleId){
		return userRoleMapService.getUserRoleByRoleId(roleId);
	}
	
	@GetMapping("getUserRoleByMappingId/{mappingid}")
	public ResponseEntity<UserRoleMapDTO> getUserRoleByMappingId(@PathVariable("mappingid") Long mappingId){
		return userRoleMapService.getUserRoleByMappingId(mappingId);
	}
	
	@PostMapping("mapUserRole")
	public ResponseEntity<UserRoleMapDTO> persistUserRoleMapping(@RequestBody UserRoleMapDTO userRoleMapDTO){
		return userRoleMapService.persistUserRoleMapping(userRoleMapDTO);
	}
	
	@DeleteMapping("deleteUserRoleMapping/{mappingid}")
	public void destroyUserRoleMapping(@PathVariable("mappingid") Long mappingId) {
		userRoleMapService.destroyUserRoleMapping(mappingId);
	}

}
