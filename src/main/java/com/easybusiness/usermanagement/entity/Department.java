package com.easybusiness.usermanagement.entity;

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
@Table(name="DEPARTMENT")
public class Department {

	@Id
    @Column(name = "DEPT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPARTMENT_SEQ")
	@SequenceGenerator(name="DEPARTMENT_SEQ", sequenceName="DEPARTMENT_SEQ")
    private long id;

    @ManyToOne(cascade = { CascadeType.PERSIST },fetch= FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    private Organization organization;

    @Column(name = "DEPT_NAME")
    private String deptName;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public Department(long id, Organization organization, String deptName, String modBy, Date modOn) {
		super();
		this.id = id;
		this.organization = organization;
		this.deptName = deptName;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", modBy=" + modBy + ", modOn=" + modOn + "]";
	}
    
	
}
