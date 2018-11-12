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

import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserGroupMapDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserGroupMappingServiceImpl;

/*
 * Service and RestController for UserGroupMap
 */
@RestController
@RequestMapping("/easybusiness/usergroup/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserGroupMappingController {
	
	@Autowired
	UserGroupMappingServiceImpl usergroupService;
	
	@GetMapping("getByUserGroupId/{usergroupid}")
	public List<UserGroupMapDTO> getUserGroupMapByGroupId(@PathVariable("usergroupid") Long userGroupId){
		return usergroupService.getUserGroupMapByGroupId(userGroupId);
	}
	
	@GetMapping("getAllUsersOfGroup/{usergroupid}")
	public List<UserDTO> getAllUsersOfGroup(@PathVariable("usergroupid") Long userGroupId){
		return usergroupService.getAllUsersOfGroup(userGroupId);
	}
	
	@GetMapping("getAllUsersOfGroupByGroupName/{usergroupname}")
	public List<UserDTO> getAllUsersOfGroupByGroupName(@PathVariable("usergroupname") String userGroupName){
		return usergroupService.getAllUsersOfGroupByGroupName(userGroupName);
	}
	
	@GetMapping("getByUserId/{userid}")
	public List<UserGroupMapDTO> getUserGroupMapByUserId(@PathVariable("userid") Long userId){
		return usergroupService.getUserGroupMapByUserId(userId);
	}
	
	@GetMapping("getByMappingId/{mappingid}")
	public ResponseEntity<UserGroupMapDTO> getUserGroupMapByMappingId(@PathVariable("mappingid")
																		Long mappingId){
		return usergroupService.getUserGroupMapByMappingId(mappingId);
	}
	
	@PostMapping("mapUserGroup")
	public ResponseEntity<UserGroupMapDTO> persistUserGroupMapping(@RequestBody UserGroupMapDTO userGroupMapDTO){
		return usergroupService.persistUserGroupMapping(userGroupMapDTO);
	}
	
	@DeleteMapping("deleteUserGroupMapping/{mappingid}")
	public void destroyUserGroupMapping(@PathVariable("mappingid") Long mappingId) {
		usergroupService.destroyUserGroupMapping(mappingId);
	}

}
