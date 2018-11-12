package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserGroup;

public class UserGroupMappingDTO {
	
	private UserGroup userGroup;
	private UserDTO users;
	
	
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	public UserDTO getUsers() {
		return users;
	}
	public void setUsers(UserDTO user) {
		this.users = user;
	}
	
	

}
