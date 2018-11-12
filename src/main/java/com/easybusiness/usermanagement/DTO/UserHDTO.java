package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class UserHDTO {

	UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}

	public UserHDTO(UserDTO user) {
		super();
		this.user = user;
	}

	public UserHDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserHDTO [user=" + user + "]";
	}
	
	
	
}
