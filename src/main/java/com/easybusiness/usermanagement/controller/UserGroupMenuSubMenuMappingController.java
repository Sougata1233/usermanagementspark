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

import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenu1DTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenuDTO;
import com.easybusiness.usermanagement.entity.UserGroupMenuSubMenu;
import com.easybusiness.usermanagement.services.serviceimpl.UserGroupMenuSubMenuMappingServiceImpl;

/*
 * Service and RestController class for usergroupmenusubmenu
 */
@RestController
@RequestMapping("/easybusiness/usergroupmenusubmenu/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserGroupMenuSubMenuMappingController {
	
	@Autowired
	UserGroupMenuSubMenuMappingServiceImpl groupmenusubmenuService;
	
	@GetMapping("getUserGroupMenuByMappingId/{mappingid}")
	public ResponseEntity<UserGroupMenuSubMenuDTO> getUserGroupMenuBymappingId(
		    @PathVariable("mappingid") Long mappingId) {
		return groupmenusubmenuService.getUserGroupMenuBymappingId(mappingId);
	}
	
	@GetMapping("getUserGroupMenuByGroupId/{groupid}")
	public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupId(@PathVariable("groupid") Long groupId){
		return groupmenusubmenuService.getUserGroupMenuByGroupId(groupId);
	}
	
	@GetMapping("getAllSubMenusAndMenusByGroupId/{groupid}")
	public List<SubMenuDTO> getAllSubMenusAndMenusByGroupId(@PathVariable("groupid") Long groupId){
		return groupmenusubmenuService.getAllSubMenusAndMenusByGroupId(groupId);
	}
	
	@GetMapping("getAllSubMenusAndMenusByGroupName/{groupname}")
	public List<SubMenuDTO> getAllSubMenusAndMenusByGroupName(@PathVariable("groupname") String groupName){
		return groupmenusubmenuService.getAllSubMenusAndMenusByGroupName(groupName);
	}
	
	@GetMapping("getUserGroupMenuByGroupMenu/{groupname}")
	public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupName(@PathVariable("groupname")
																				String groupName) {
		return groupmenusubmenuService.getUserGroupMenuByGroupName(groupName);
	}
	
	@GetMapping("getUserGroupMenuByMenuId/{menuid}")
	public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByMenuId(@PathVariable("menuid") Long menuId){
		return groupmenusubmenuService.getUserGroupMenuByMenuId(menuId);
	}
	
	@PostMapping("mapUserGroupMenuSubMenu")
	public ResponseEntity<UserGroupMenuSubMenuDTO> persistUserGroupMenu(
		    @RequestBody UserGroupMenuSubMenuDTO userGroupMenuSubMenuDTO){
		return groupmenusubmenuService.persistUserGroupMenu(userGroupMenuSubMenuDTO);
	}
	
	@PutMapping("deleteUserGroupMenu/{mappingid}")
	public void destroyUserGroupMenu(@PathVariable("mappingid") Long mappingId) {
		groupmenusubmenuService.destroyUserGroupMenu(mappingId);
	}
	
	@GetMapping("getUserGroupMenuSubMenuByUser/{userid}")
	public List<UserGroupMenuSubMenu1DTO> getUserGroupMenuSubMenuByUser(@PathVariable("userid") Long userid){
		return groupmenusubmenuService.getUserGroupMenuSubMenuByUser(userid);
	}
	
	@PutMapping("updateUserGroupMenuSubMenuByUser")
	public void updateUserGroupMenuSubMenuByUser(@RequestBody List<UserGroupMenuSubMenu> userGroupMenuSubMenu) {
		groupmenusubmenuService.updateUserGroupMenuSubMenuByUser(userGroupMenuSubMenu);
	}

}
