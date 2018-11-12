package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.SubMenu;

public class MenuSubMenuDTO {
	
	private String menuDetails;
	private List<SubMenu> subMenu;
	
	public String getMenuDetails() {
		return menuDetails;
	}
	public void setMenuDetails(String menuDetails) {
		this.menuDetails = menuDetails;
	}
	public List<SubMenu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<SubMenu> subMenu) {
		this.subMenu = subMenu;
	}
	public MenuSubMenuDTO(String menuDetails, List<SubMenu> subMenu) {
		super();
		this.menuDetails = menuDetails;
		this.subMenu = subMenu;
	}
	public MenuSubMenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MenuSubMenuDTO [menuDetails=" + menuDetails + ", subMenu=" + subMenu + "]";
	}
	
	
	
	

}
