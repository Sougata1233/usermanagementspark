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

import com.easybusiness.usermanagement.DTO.UserGroupDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserGroupServiceImpl;

/*
 * Service and RestController class for USER_GROUP_MASTER table
 */
@RestController
@RequestMapping("/easybusiness/usergroup/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserGroupController {
	
	@Autowired
	UserGroupServiceImpl groupService;
	
	@GetMapping("getByUsergroupName/{usergroupname}")
	public ResponseEntity<UserGroupDTO> getUserGroupByName(@PathVariable("usergroupname") String userGroupName){
		return groupService.getUserGroupByName(userGroupName);
	}
	
	@GetMapping("getByUsergroupId/{usergroupid}")
	public ResponseEntity<UserGroupDTO> getUserGroupById(@PathVariable("usergroupid") Long userGroupId){
		return groupService.getUserGroupById(userGroupId);
	}
	
	@PostMapping("addUserGroup")
	public ResponseEntity<UserGroupDTO> persistUserGroup(@RequestBody UserGroupDTO userGroupDTO){
		return groupService.persistUserGroup(userGroupDTO);
	}
	
	@PostMapping("updateUserGroup")
	public void updateUserGroup(@RequestBody UserGroupDTO userGroupDto) {
		groupService.updateUserGroup(userGroupDto);
	}
	
	@GetMapping("getAllUserGroup")
	public List<UserGroupDTO> populateUserGroupList() throws Exception{
		return groupService.populateUserGroupList();
	}
	
	@DeleteMapping("deleteUserGroup/{userGroupId}")
	public void destroyUserGroup(@PathVariable("userGroupId") Long userGroupId) {
		groupService.destroyUserGroup(userGroupId);
	}

}
