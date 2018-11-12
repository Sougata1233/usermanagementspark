package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.UserProfessionDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserProfessionServiceImpl;

@RestController
@RequestMapping("/easybusiness/user/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserProfessionController {
	
	@Autowired
	UserProfessionServiceImpl userProfessionService;
	
	@GetMapping("getUserProfession/{userid}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<UserProfessionDTO> getUserProfession(@PathVariable("userid") Long userId){
		return userProfessionService.getUserProfession(userId);
	}
	
	@PostMapping("addUserProfession")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserProfessionDTO> persistUserProfession(
										@RequestBody UserProfessionDTO userProfession){
		return userProfessionService.persistUserProfession(userProfession);
	}
	
	@PostMapping("updateUserProfession")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserProfessionDTO> updateUserProfession(
    		@RequestBody UserProfessionDTO userProfession) {
    			return userProfessionService.updateUserProfession(userProfession);
    }
	

}
