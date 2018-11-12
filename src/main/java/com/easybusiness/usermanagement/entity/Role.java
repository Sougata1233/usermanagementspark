package com.easybusiness.usermanagement.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="ROLE_DETAILS")
public class Role {

    @Id
    @Column(name="ROLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "IS_ENABLE")
    private Long isEnable;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "TO_DATE")
    private Date toDate;

    @Column(name = "MOD_BY")
    private String modifiedBy;
    
    @Column(name = "MOD_ON")
    private Date modifiedOn;
    

    public Role() {
	super();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
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
	return "Role [id=" + id + ", role=" + role + ", isEnable=" + isEnable + ", fromDate=" + fromDate + ", toDate="
		+ toDate + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
    }

   
    
    
    

}
