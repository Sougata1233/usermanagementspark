package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.UserGroup;

public class UserGroupMenuMappingDTO {
	
	private List<Menu> menu;
	private UserGroup usergroups;
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public UserGroup getUsergroups() {
		return usergroups;
	}
	public void setUsergroups(UserGroup usergroups) {
		this.usergroups = usergroups;
	}
	
	
	

}
