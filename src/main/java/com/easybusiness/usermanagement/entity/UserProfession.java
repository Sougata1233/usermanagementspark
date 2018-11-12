package com.easybusiness.usermanagement.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;

@Entity
@Table(name = "USER_PROFESSION")
public class UserProfession implements Serializable {
    
    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_PROFESSION_SEQ")
    @SequenceGenerator(name="USER_PROFESSION_SEQ", sequenceName="USER_PROFESSION_SEQ")
    private Long id;

    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;
    
    @Column(name="ORGANISATION")
    private String organisation;
    
    @Column(name="OTHER_SKILL")
    private String otherSkill;
    
    @Column(name="PRIMARY_SKILL")
    private String primarySkill;
    
    @Column(name="PROJECT_DESC")
    private String projectDesc;
    
    @Column(name="PROJECT_DURATION")
    private String projectDuration;
    
    @Column(name="PROJECT_END_DATE")
    private Date projectEndDate;
    
    @Column(name="PROJECT_NAME")
    private String projectName;
    
    @Column(name="PROJECT_ROLE")
    private String projectRole;
    
    @Column(name="PROJECT_START_DATE")
    private Date projectStartDate;
    
    @Column(name="USER_ID")
    private Long user;

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganization(String organisation) {
		this.organisation = organisation;
	}

	public String getOtherSkill() {
		return otherSkill;
	}

	public void setOtherSkill(String otherSkill) {
		this.otherSkill = otherSkill;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public UserProfession(Long id, String modBy, Date modOn, String organization, String otherSkill,
			String primarySkill, String projectDesc, String projectDuration, Date projectEndDate, String projectName,
			String projectRole, Date projectStartDate) {
		super();
		this.id = id;
		this.modBy = modBy;
		this.modOn = modOn;
		this.organisation = organization;
		this.otherSkill = otherSkill;
		this.primarySkill = primarySkill;
		this.projectDesc = projectDesc;
		this.projectDuration = projectDuration;
		this.projectEndDate = projectEndDate;
		this.projectName = projectName;
		this.projectRole = projectRole;
		this.projectStartDate = projectStartDate;
	}

	public UserProfession() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserProfession [id=" + id + ", modBy=" + modBy + ", modOn=" + modOn + ", organization=" + organisation
				+ ", otherSkill=" + otherSkill + ", primarySkill=" + primarySkill + ", projectDesc=" + projectDesc
				+ ", projectDuration=" + projectDuration + ", projectEndDate=" + projectEndDate + ", projectName="
				+ projectName + ", projectRole=" + projectRole + ", projectStartDate=" + projectStartDate + "]";
	}
    
    

   

}
