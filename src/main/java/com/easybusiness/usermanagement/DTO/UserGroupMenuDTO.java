package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class UserGroupMenuDTO implements Serializable {

    private static final long serialVersionUID = 536872931329532182L;

    private Long id;

    private MenuDTO menuItem;

    private UserGroupDTO userGroup;

    private Long isEnable;

    private Date fromDate;

    private Date toDate;

    private String modifiedBy;

    private Date modifiedOn;

    public UserGroupMenuDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public UserGroupDTO getUserGroup() {
	return userGroup;
    }

    public void setUserGroup(UserGroupDTO userGroup) {
	this.userGroup= userGroup;
    }

   

    public MenuDTO getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuDTO menuItem) {
        this.menuItem = menuItem;
    }

    public Long getIsEnable() {
	return isEnable;
    }

    public void setIsEnable(Long isEnable) {
	this.isEnable = isEnable;
    }

    public Date getFromDate() {
	return fromDate;
    }

    public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
    }

    public Date getToDate() {
	return toDate;
    }

    public void setToDate(Date toDate) {
	this.toDate = toDate;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
	return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
	return "UserMenu [id=" + id + ",  userGroup=" + userGroup + ", menu=" + menuItem + ", isEnable=" + isEnable
		+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", modifiedBy=" + modifiedBy + ", modifiedOn="
		+ modifiedOn + "]";
    }

}
