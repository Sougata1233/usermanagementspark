package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
public class Organization {

	@Id
    @Column(name = "ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORGANIZATION_SEQ")
	@SequenceGenerator(name="ORGANIZATION_SEQ", sequenceName="ORGANIZATION_SEQ")
    private long id;

    
    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "HIERARCHY_ID")
    private long hierarchyId;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;
    
    @Column(name="SHORT_CODE")
    private String shortCode;
    
    @Column(name="ORG_TYPE")
    private String orgType;
    
    @Column(name="LOCATION_ID")
    private long locationId;
    
    
    
    

	public long getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(long hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Organization(long id, String orgName, long hierarchyId, String modBy, Date modOn, String shortCode,
			String orgType) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.hierarchyId = hierarchyId;
		this.modBy = modBy;
		this.modOn = modOn;
		this.shortCode = shortCode;
		this.orgType = orgType;
	}

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", orgName=" + orgName + ", hierarchyId=" + hierarchyId + ", modBy=" + modBy
				+ ", modOn=" + modOn + ", shortCode=" + shortCode + ", orgType=" + orgType + "]";
	}
    
    
	
}
