package com.easybusiness.usermanagement.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_HIERARCY")
public class UserHierarchy {
	
	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_HIERARCY_SEQ")
	@SequenceGenerator(name="USER_HIERARCY_SEQ", sequenceName="USER_HIERARCY_SEQ")
	@Column(name="HIERARCY_ID")
	private long hierarcyId;
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="PRACTICE_ID")
	private PracticeMaster practiceMaster;
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="PRJ_ID")
	private ProjectMaster projectMaster;
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="PRI_SUPERVISOR_ID")
	private User priSupervisor;
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="PRJ_SUPERVISOR_ID")
	private User prjSupervisor;
	
	public User getPrjSupervisor() {
		return prjSupervisor;
	}

	public void setPrjSupervisor(User prjSupervisor) {
		this.prjSupervisor = prjSupervisor;
	}

	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="HR_MNGR_ID")
	private User hrManager;
	
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	@Column(name="TO_DATE")
	private Date toDate;
	
	@Column(name="PRJ_ALLOC_DATE")
	private Date prjAllocDate;
	
	@Column(name="PRJ_RELEASE_DATE")
	private Date prjReleaseDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;
	
	//@Column(name="ORG_ID")
	@OneToOne
    @JoinColumn(name = "ORG_ID")
    private Organization orgId;
	
	//@Column(name="PARENT_ORG_ID")
	@OneToOne
    @JoinColumn(name = "PARENT_ORG_ID")
	private Organization parentOrgId;
	
//	@Column(name="ORG_HEAD")
	/*@OneToMany(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="ORG_HEAD")
	private List<UserDTO> orgHead;
	
	public List<UserDTO> getOrgHead() {
		return orgHead;
	}

	public void setOrgHead(List<UserDTO> orgHead) {
		this.orgHead = orgHead;
	}*/
	
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="ORG_HEAD")
	private User orgHead;
	
	public User getOrgHead() {
		return orgHead;
	}

	public void setOrgHead(User userDTO) {
		this.orgHead = userDTO;
	}
	
	/*@OneToMany(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="GROUP_HEAD")
	private List<UserDTO> groupHead;*/
	
	

	

	//	@Column(name="GROUP_HEAD")
	@OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
	@JoinColumn(name="GROUP_HEAD")
	private User groupHead;
	
	

	public User getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(User groupHead) {
		this.groupHead = groupHead;
	}

	

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

	

	
	
	/*public List<UserDTO> getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(List<UserDTO> groupHead) {
		this.groupHead = groupHead;
	}*/

	public long getHierarcyId() {
		return hierarcyId;
	}

	public void setHierarcyId(long hierarcyId) {
		hierarcyId = hierarcyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userDTO) {
		this.user = userDTO;
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

	public User getPriSupervisor() {
		return priSupervisor;
	}

	public void setPriSupervisor(User userDTO) {
		this.priSupervisor = userDTO;
	}

	public User getHrManager() {
		return hrManager;
	}

	public void setHrManager(User userDTO) {
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

	public UserHierarchy(long hierarcyId, User user, PracticeMaster practiceMaster, ProjectMaster projectMaster,
			User priSupervisor, User hrManager, Date fromDate, Date toDate, Date prjAllocDate, Date prjReleaseDate,
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

	public UserHierarchy() {
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
