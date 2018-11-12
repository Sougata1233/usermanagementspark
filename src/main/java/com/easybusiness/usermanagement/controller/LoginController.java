package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.entity.UserLoginDetails;
import com.easybusiness.usermanagement.services.serviceimpl.LoginServiceImpl;

@RestController
@RequestMapping("/easybusiness/user/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginService;
	
	@PostMapping("getLogoutDetails/{loginToken}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public UserLoginDetails LogoutUser(@PathVariable("loginToken") String loginToken) throws Exception{
		return loginService.LogoutUser(loginToken);
	}
	
	@PostMapping("login/{userName}/{password}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public UserLoginDetails getLoginDetails(@PathVariable("userName") String userName,
			@PathVariable("password") String password) throws Exception{
		return loginService.getLoginDetails(userName, password);
	}

}
