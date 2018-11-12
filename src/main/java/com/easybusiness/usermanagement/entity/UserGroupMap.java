package com.easybusiness.usermanagement.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "USER_GROUP_MAP_MASTER")
public class UserGroupMap implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5300599187745769139L;

    @Id
    @Column(name = "MAPPING_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_GRP_MAP_MASTER_SEQ")
    @SequenceGenerator(name="USER_GRP_MAP_MASTER_SEQ", sequenceName="USER_GRP_MAP_MASTER_SEQ")
    private Long id;

    @ManyToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_GRP_ID")
    private UserGroup userGroup;

   
    
    @ManyToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

   

    @Column(name = "IS_ENABLE")
    private Long isEnable;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "END_DATE")
    private Date toDate;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;

    public UserGroupMap() {
	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
	return "UserGroupMap [id=" + id + ", userGroup=" + userGroup + ", user=" + user + ", isEnable=" + isEnable
		+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", modifiedBy=" + modifiedBy + ", modifiedOn="
		+ modifiedOn + "]";
    }

   

}
