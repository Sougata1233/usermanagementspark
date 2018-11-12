package com.easybusiness.usermanagement.DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class UserGroupDTO {

    private Long id;

    private String userGroupName;

    private Long isEnable;

    private Date fromDate;

    private Date toDate;

    private String modifiedBy;

    private Date modifiedOn;

    public UserGroupDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUserGroupName() {
	return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
	this.userGroupName = userGroupName;
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
	return "UserGroup [id=" + id + ", userGroupName=" + userGroupName + ", isEnable=" + isEnable + ", fromDate="
		+ fromDate + ", toDate=" + toDate + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
    }

}
