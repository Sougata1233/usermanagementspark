package com.easybusiness.usermanagement.DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class OrganizationDto {

    private long id;

    private String orgName;

    private long hierarchyId;
    
    private String modBy;
    
    private Date modOn;
    
    private String shortCode;
    
    private String orgType;
    
    private long locationId;
    
    

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

	

	public long getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(long hierarchyId) {
		this.hierarchyId = hierarchyId;
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

	

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", orgName=" + orgName + ", hierarchyId=" + hierarchyId + ", modBy=" + modBy
				+ ", modOn=" + modOn + ", shortCode=" + shortCode + ", orgType=" + orgType + "]";
	}
    
	
}
