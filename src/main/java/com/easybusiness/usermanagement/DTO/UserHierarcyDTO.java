package com.easybusiness.usermanagement.DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.PracticeMaster;
import com.easybusiness.usermanagement.entity.ProjectMaster;
import com.easybusiness.usermanagement.entity.User;

public class UserHierarcyDTO {

	
	private long hierarcyId;
	
	public long getHierarcyId() {
		return hierarcyId;
	}

	public void setHierarcyId(long hierarcyId) {
		this.hierarcyId = hierarcyId;
	}

	private UserDTO user;
	
	private PracticeMaster practiceMaster;
	
	private ProjectMaster projectMaster;
	
	private UserDTO priSupervisor;
	
	private UserDTO hrManager;
	
	private Date fromDate;
	
	private Date toDate;
	
	private Date prjAllocDate;
	
	private Date prjReleaseDate;
	
	private String status;
	
	private String modBy;
	
	private Date modOn;
	
    private Organization orgId;
		
	private Organization parentOrgId;
	
	private UserDTO orgHead;
	public void setOrgHead(UserDTO orgHead) {
		this.orgHead = orgHead;
	}
		
	public UserDTO getOrgHead() {
		return orgHead;
	}
	
	private UserDTO groupHead;
	
	

	public Organization getOrgId() {
		return orgId;
	}

	public void setOrgId(Organization orgId) {
		this.orgId = orgId;
	}

	public Organization getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(Organization parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	

	public UserDTO getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(UserDTO userDTO) {
		this.groupHead = userDTO;
	}

	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public PracticeMaster getPracticeMaster() {
		return practiceMaster;
	}

	public void setPracticeMaster(PracticeMaster practiceMaster) {
		this.practiceMaster = practiceMaster;
	}

	public ProjectMaster getProjectMaster() {
		return projectMaster;
	}

	public void setProjectMaster(ProjectMaster projectMaster) {
		this.projectMaster = projectMaster;
	}

	public UserDTO getPriSupervisor() {
		return priSupervisor;
	}

	public void setPriSupervisor(UserDTO userDTO) {
		this.priSupervisor = userDTO;
	}

	public UserDTO getHrManager() {
		return hrManager;
	}

	public void setHrManager(UserDTO userDTO) {
		this.hrManager = userDTO;
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

	public Date getPrjAllocDate() {
		return prjAllocDate;
	}

	public void setPrjAllocDate(Date prjAllocDate) {
		this.prjAllocDate = prjAllocDate;
	}

	public Date getPrjReleaseDate() {
		return prjReleaseDate;
	}

	public void setPrjReleaseDate(Date prjReleaseDate) {
		this.prjReleaseDate = prjReleaseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public UserHierarcyDTO(long hierarcyId, UserDTO user, PracticeMaster practiceMaster, ProjectMaster projectMaster,
			UserDTO priSupervisor, UserDTO hrManager, Date fromDate, Date toDate, Date prjAllocDate, Date prjReleaseDate,
			String status, String modBy, Date modOn) {
		super();
		hierarcyId = hierarcyId;
		this.user = user;
		this.practiceMaster = practiceMaster;
		this.projectMaster = projectMaster;
		this.priSupervisor = priSupervisor;
		this.hrManager = hrManager;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.prjAllocDate = prjAllocDate;
		this.prjReleaseDate = prjReleaseDate;
		this.status = status;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	public UserHierarcyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserHierarchy [HierarcyId=" + hierarcyId + ", user=" + user + ", practiceMaster=" + practiceMaster
				+ ", projectMaster=" + projectMaster + ", priSupervisor=" + priSupervisor + ", hrManager=" + hrManager
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", prjAllocDate=" + prjAllocDate
				+ ", prjReleaseDate=" + prjReleaseDate + ", status=" + status + ", modBy=" + modBy + ", modOn=" + modOn
				+ "]";
	}
	
	
	
	
}
