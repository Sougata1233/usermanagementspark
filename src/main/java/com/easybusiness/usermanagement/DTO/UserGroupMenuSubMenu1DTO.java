package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class UserGroupMenuSubMenu1DTO {

	private long mappingId;
	private UserDTO userId;
	private MenuSubMenuDTO menu;
//	private SubMenuDTO submenu;
	private long readOnly;
	
	
	
	
	
	public long getMappingId() {
		return mappingId;
	}
	public void setMappingId(long mappingId) {
		this.mappingId = mappingId;
	}
	public UserDTO getUserId() {
		return userId;
	}
	public void setUserId(UserDTO userId) {
		this.userId = userId;
	}
	public MenuSubMenuDTO getMenu() {
		return menu;
	}
	public void setMenu(MenuSubMenuDTO list) {
		this.menu = list;
	}
	/*public SubMenuDTO getSubmenu() {
		return submenu;
	}
	public void setSubmenu(SubMenuDTO submenu) {
		this.submenu = submenu;
	}*/
	public long getReadOnly() {
		return readOnly;
	}
	public void setReadOnly(long readOnly) {
		this.readOnly = readOnly;
	}
	public UserGroupMenuSubMenu1DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserGroupMenuSubMenu1DTO(long mappingId, UserDTO userId, MenuSubMenuDTO menu, long readOnly) {
		super();
		this.mappingId = mappingId;
		this.userId = userId;
		this.menu = menu;
		this.readOnly = readOnly;
	}
	@Override
	public String toString() {
		return "UserGroupMenuSubMenu1DTO [userId=" + userId + ", menu=" + menu + ", readOnly="
				+ readOnly + "]";
	}
	
	
	
}
