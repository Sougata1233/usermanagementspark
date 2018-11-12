package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class SubMenuDTO implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    private Long id;

    private MenuDTO menu;

    private String subMenu;

    private Date modifiedTime;
    
    private String modifiedBy;

    public SubMenuDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }


    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
	return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
	this.modifiedTime = modifiedTime;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public String toString() {
	return "SubMenu [id=" + id + ", menu=" + menu + ", subMenu=" + subMenu + ", modifiedTime=" + modifiedTime
		+ ", modifiedBy=" + modifiedBy + "]";
    }

    

}
