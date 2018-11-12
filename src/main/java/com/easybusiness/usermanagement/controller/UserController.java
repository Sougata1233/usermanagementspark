package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.UserAcademicsDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserProfessionDTO;
import com.easybusiness.usermanagement.entity.UserLoginDetails;
import com.easybusiness.usermanagement.services.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/easybusiness/user/")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("getByUserName/{username}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserDTO> getUserByUserName(@PathVariable("username") String userName){
		UserDTO userEntity = userService.getUser(userName);	//fetching user entity by username
		return new ResponseEntity<UserDTO>(userEntity, HttpStatus.OK);
	}
	
	@PostMapping("addUser")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
		userService.persistUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("updateUser")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
		userService.updateUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
	}
	
	
	@GetMapping("getAllUsers")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<UserDTO> getAllUsers(){
		return userService.populateUserList();
	}
	
	@GetMapping("getByUserId/{userId}")
	public UserDTO populateOneUserDetails(@PathVariable("userId") Long userId) {
		return userService.populateOneUserDetails(userId);
	}
	
	@DeleteMapping("deleteUser/{userId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public void destroyUser(@PathVariable("userId") Long userId) {
		userService.destroyUser(userId);
	}
	
	@PostMapping("activateUser/{userId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public void activateUser(@PathVariable("userId") Long userId) {
		userService.activateUser(userId);
	}
	
	@PostMapping("deactivateUser/{userId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public void deActivateUser(@PathVariable("userId") Long userId) {
		userService.deActivateUser(userId);
	}
	
}
