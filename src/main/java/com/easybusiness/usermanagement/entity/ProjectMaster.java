package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_MASTER")
public class ProjectMaster {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRJ_ID")
	private long prjId;
	
	@Column(name="PRJ_NAME")
	private String prjName;
	
	@Column(name="PRJ_DESC")
	private String prjDesc;
	
	@Column(name="PRJ_START_DT")
	private Date prjStartDt;
	
	@Column(name="PRJ_END_DT")
	private Date prjEndDt;
	
	@Column(name="PRJ_ACTUAL_START_DT")
	private Date prjActualStartDt;
	
	@Column(name="PRJ_ACTUAL_END_DT")
	private Date prjActualEndDt;
	
	@Column(name="PLANNED_DURATION")
	private long plannedDuration;
	
	@Column(name="ACTUAL_DURATION")
	private long actualDuration;
	
	@Column(name="PRJ_ALLOC_BUDGET")
	private long prjAllocBudget;
	
	@Column(name="PRJ_AVL_BUDGET")
	private long prjAvlBudget;
	
	@Column(name="PRJ_STATUS")
	private String prjcStatus;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;

	public long getPrjId() {
		return prjId;
	}

	public void setPrjId(long prjId) {
		this.prjId = prjId;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjDesc() {
		return prjDesc;
	}

	public void setPrjDesc(String prjDesc) {
		this.prjDesc = prjDesc;
	}

	public Date getPrjStartDt() {
		return prjStartDt;
	}

	public void setPrjStartDt(Date prjStartDt) {
		this.prjStartDt = prjStartDt;
	}

	public Date getPrjEndDt() {
		return prjEndDt;
	}

	public void setPrjEndDt(Date prjEndDt) {
		this.prjEndDt = prjEndDt;
	}

	public Date getPrjActualStartDt() {
		return prjActualStartDt;
	}

	public void setPrjActualStartDt(Date prjActualStartDt) {
		this.prjActualStartDt = prjActualStartDt;
	}

	public Date getPrjActualEndDt() {
		return prjActualEndDt;
	}

	public void setPrjActualEndDt(Date prjActualEndDt) {
		this.prjActualEndDt = prjActualEndDt;
	}

	public long getPlannedDuration() {
		return plannedDuration;
	}

	public void setPlannedDuration(long plannedDuration) {
		this.plannedDuration = plannedDuration;
	}

	public long getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(long actualDuration) {
		this.actualDuration = actualDuration;
	}

	public long getPrjAllocBudget() {
		return prjAllocBudget;
	}

	public void setPrjAllocBudget(long prjAllocBudget) {
		this.prjAllocBudget = prjAllocBudget;
	}

	public long getPrjAvlBudget() {
		return prjAvlBudget;
	}

	public void setPrjAvlBudget(long prjAvlBudget) {
		this.prjAvlBudget = prjAvlBudget;
	}

	public String getPrjcStatus() {
		return prjcStatus;
	}

	public void setPrjcStatus(String prjcStatus) {
		this.prjcStatus = prjcStatus;
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

	public ProjectMaster(long prjId, String prjName, String prjDesc, Date prjStartDt, Date prjEndDt,
			Date prjActualStartDt, Date prjActualEndDt, long plannedDuration, long actualDuration, long prjAllocBudget,
			long prjAvlBudget, String prjcStatus, String modBy, Date modOn) {
		super();
		this.prjId = prjId;
		this.prjName = prjName;
		this.prjDesc = prjDesc;
		this.prjStartDt = prjStartDt;
		this.prjEndDt = prjEndDt;
		this.prjActualStartDt = prjActualStartDt;
		this.prjActualEndDt = prjActualEndDt;
		this.plannedDuration = plannedDuration;
		this.actualDuration = actualDuration;
		this.prjAllocBudget = prjAllocBudget;
		this.prjAvlBudget = prjAvlBudget;
		this.prjcStatus = prjcStatus;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	public ProjectMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProjectMaster [prjId=" + prjId + ", prjName=" + prjName + ", prjDesc=" + prjDesc + ", prjStartDt="
				+ prjStartDt + ", prjEndDt=" + prjEndDt + ", prjActualStartDt=" + prjActualStartDt + ", prjActualEndDt="
				+ prjActualEndDt + ", plannedDuration=" + plannedDuration + ", actualDuration=" + actualDuration
				+ ", prjAllocBudget=" + prjAllocBudget + ", prjAvlBudget=" + prjAvlBudget + ", prjcStatus=" + prjcStatus
				+ ", modBy=" + modBy + ", modOn=" + modOn + "]";
	}
	
	

}
