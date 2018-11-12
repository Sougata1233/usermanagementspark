package com.easybusiness.usermanagement.DTO;

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
import javax.persistence.Table;

import com.easybusiness.usermanagement.entity.Organization;

public class DepartmentDto {

    private long id;

    private OrganizationDto organization;

    private String deptName;
    
    private String modBy;
    
    private Date modOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrganizationDto getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDto orgDTO) {
		this.organization = orgDTO;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public DepartmentDto(long id, OrganizationDto organization, String deptName, String modBy, Date modOn) {
		super();
		this.id = id;
		this.organization = organization;
		this.deptName = deptName;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", modBy=" + modBy + ", modOn=" + modOn + "]";
	}
    
	
}
