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

import com.easybusiness.usermanagement.DTO.UserAcademicsDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserAcademicsServiceImpl;

@RestController
@RequestMapping("/easybusiness/user/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserAcademicsController {
	
	@Autowired
	UserAcademicsServiceImpl userAcademicsService;
	
	@GetMapping("getUserAcademics/{userid}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<UserAcademicsDTO> getUserAcademics(@PathVariable("userid") Long userId){
		return userAcademicsService.getUserAcademics(userId);
	}
	
	
	@PostMapping("addUserAcademics")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserAcademicsDTO> persistUserAcademics(@RequestBody UserAcademicsDTO userAcademics){
		return userAcademicsService.persistUserAcademics(userAcademics);
	}
	
	@PostMapping("updateUserAcademics")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserAcademicsDTO> updateUserAcademics(
			@RequestBody UserAcademicsDTO userAcademics) {
		return userAcademicsService.updateUserAcademics(userAcademics);
	}

}
