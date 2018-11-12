package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.easybusiness.usermanagement.entity.User;

public class UserProfessionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id;

    private String modBy;
    
    private Date modOn;
    
    private String organization;
    
    private String otherSkill;
    
    private String primarySkill;
    
    private String projectDesc;
    
    private String projectDuration;
    
    private Date projectEndDate;
    
    private String projectName;
    
    private String projectRole;
    
    private Date projectStartDate;
    
    private Long user;
    
    private String totalExp;

	public String getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(String diff) {
		this.totalExp = diff;
	}

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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public void setProjectEndDate(Date date) {
		this.projectEndDate = date;
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

	

	public UserProfessionDTO(Long id, String modBy, Date modOn, String organization, String otherSkill,
			String primarySkill, String projectDesc, String projectDuration, Date projectEndDate, String projectName,
			String projectRole, Date projectStartDate) {
		super();
		this.id = id;
		this.modBy = modBy;
		this.modOn = modOn;
		this.organization = organization;
		this.otherSkill = otherSkill;
		this.primarySkill = primarySkill;
		this.projectDesc = projectDesc;
		this.projectDuration = projectDuration;
		this.projectEndDate = projectEndDate;
		this.projectName = projectName;
		this.projectRole = projectRole;
		this.projectStartDate = projectStartDate;
	}

	public UserProfessionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserProfession [id=" + id + ", modBy=" + modBy + ", modOn=" + modOn + ", organization=" + organization
				+ ", otherSkill=" + otherSkill + ", primarySkill=" + primarySkill + ", projectDesc=" + projectDesc
				+ ", projectDuration=" + projectDuration + ", projectEndDate=" + projectEndDate + ", projectName="
				+ projectName + ", projectRole=" + projectRole + ", projectStartDate=" + projectStartDate + "]";
	}
    
    

}
