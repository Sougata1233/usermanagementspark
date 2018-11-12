package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserGroup;

public class UserGroupMenuSubMenuMappingDTO {
	
	private SubMenu submenu;
	private List<UserGroup> usergroups;
	public SubMenu getSubmenu() {
		return submenu;
	}
	public void setSubmenu(SubMenu submenu) {
		this.submenu = submenu;
	}
	public List<UserGroup> getUsergroups() {
		return usergroups;
	}
	public void setUsergroups(List<UserGroup> usergroups) {
		this.usergroups = usergroups;
	}
	
	
	

}
