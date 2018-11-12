package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class MenuDTO implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    private Long id;

    private String menuName;

    private String modifiedBy;

    private Date modifiedTime;
    
    private String menuIconName;

    public MenuDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getMenuName() {
	return menuName;
    }

    public void setMenuName(String menuName) {
	this.menuName = menuName;
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

    public String getMenuIconName() {
        return menuIconName;
    }

    public void setMenuIconName(String menuIconName) {
        this.menuIconName = menuIconName;
    }

    @Override
    public String toString() {
	return "MenuDTO [id=" + id + ", menuName=" + menuName + ", modifiedBy=" + modifiedBy + ", modifiedTime="
		+ modifiedTime + ", menuIconName=" + menuIconName + "]";
    }


    
}
