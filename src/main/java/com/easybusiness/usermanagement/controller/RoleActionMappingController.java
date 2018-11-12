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

import com.easybusiness.usermanagement.DTO.RoleActionMapDTO;
import com.easybusiness.usermanagement.services.serviceimpl.RoleActionMappingServiceImpl;

/*
 * Service and RestController class for ROLE_ACTION_MAP_MASTER table
 */
@RestController
@RequestMapping("/easybusiness/roleaction/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class RoleActionMappingController {
	
	@Autowired
	RoleActionMappingServiceImpl rolemappService;
	
	@GetMapping("getActionByRoleId/{roleid}")
	public List<RoleActionMapDTO> getActionByRoleId(@PathVariable("roleid") Long roleId){
		return rolemappService.getActionByRoleId(roleId);
	}
	
	@PostMapping("mapRoleAction")
	public ResponseEntity<RoleActionMapDTO> persistRoleActionMapping(
									@RequestBody RoleActionMapDTO roleActionMapDTO){
		return rolemappService.persistRoleActionMapping(roleActionMapDTO);
	}
	
	@DeleteMapping("destroyRoleActionMapping/{mappingid}")
	public void destroyRoleActionMapping(@PathVariable("mappingid") Long mappingId) {
		rolemappService.destroyRoleActionMapping(mappingId);
	}

}
