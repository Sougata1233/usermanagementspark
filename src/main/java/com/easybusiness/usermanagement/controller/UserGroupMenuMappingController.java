package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.UserGroupMenuDTO;
import com.easybusiness.usermanagement.entity.UserGroupMenu;
import com.easybusiness.usermanagement.services.serviceimpl.UserGroupMenuMappingServiceImpl;

/*
 * Service and RestController class for UserGroupMenuMapping
 */
@RestController
@RequestMapping("/easybusiness/usergroupmenu/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserGroupMenuMappingController {
	
	@Autowired
	UserGroupMenuMappingServiceImpl UserGroupMenuMappingService;
	
	@GetMapping("getUserGroupMenuByMappingId/{mappingid}")
	public ResponseEntity<UserGroupMenuDTO> getUserGroupMenuBymappingId(@PathVariable("mappingid")
																			Long mappingId){
		return UserGroupMenuMappingService.getUserGroupMenuBymappingId(mappingId);
	}
	
	@GetMapping("getUserGroupMenuByGroupId/{groupid}")
	public List<UserGroupMenuDTO> getUserGroupMenuByGroupId(@PathVariable("groupid") Long groupId){
		return UserGroupMenuMappingService.getUserGroupMenuByGroupId(groupId);
	}
	
	@GetMapping("getUserGroupMenuByGroupName/{groupname}")
	public List<UserGroupMenuDTO> getUserGroupMenuByGroupName(@PathVariable("groupname") String groupName){
		return UserGroupMenuMappingService.getUserGroupMenuByGroupName(groupName);
	}
	
	@GetMapping("getUserGroupMenuByMenuId/{menuid}")
	public List<UserGroupMenuDTO> getUserGroupMenuByMenuId(@PathVariable("menuid") Long menuId){
		return UserGroupMenuMappingService.getUserGroupMenuByMenuId(menuId);
	}
	
	@PostMapping("mapUserGroupMenu")
	public ResponseEntity<UserGroupMenuDTO> persistUserGroupMenu(@RequestBody UserGroupMenuDTO userGroupMenuDTO){
		return UserGroupMenuMappingService.persistUserGroupMenu(userGroupMenuDTO);
	}
	
	@PutMapping("deleteUserGroupMenuItem/{mappingid}")
	public void destroyUserGroupMenu(@PathVariable("mappingid") Long mappingId) {
		UserGroupMenuMappingService.destroyUserGroupMenu(mappingId);
	}

}
