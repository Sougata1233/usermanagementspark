package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name = "USER_GROUP_MASTER")
public class UserGroup {

    @Id
    @Column(name = "USER_GRP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_GRP_MASTER_SEQ")
    @SequenceGenerator(name="USER_GRP_MASTER_SEQ", sequenceName="USER_GRP_MASTER_SEQ")
    private Long id;

    @Column(name = "USER_GRP_NAME")
    private String userGroupName;

    @Column(name = "IS_ENABLE")
    private Long isEnable;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "TO_DATE")
    private Date toDate;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_DATE")
    private Date modifiedOn;

    public UserGroup() {
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
