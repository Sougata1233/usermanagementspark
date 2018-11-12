package com.easybusiness.usermanagement.services;

import com.easybusiness.usermanagement.entity.UserLoginDetails;

public interface LoginService {
	
	public UserLoginDetails LogoutUser(String loginToken) throws Exception;

	UserLoginDetails getLoginDetails(String userName, String password) throws Exception;

}
