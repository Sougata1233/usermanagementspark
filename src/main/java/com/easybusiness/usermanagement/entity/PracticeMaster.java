package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRACTICE_MASTER")
public class PracticeMaster {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRACTICE_ID")
	private long practiceId;
	
	@Column(name="PRACTICE_NAME")
	private String practiceName;
	
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	@Column(name="TO_DATE")
	private Date toDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;

	public long getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(long practiceId) {
		this.practiceId = practiceId;
	}

	public String getPracticeName() {
		return practiceName;
	}

	public void setPracticeName(String practiceName) {
		this.practiceName = practiceName;
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

	public PracticeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PracticeMaster(long practiceId, String practiceName, Date fromDate, Date toDate, String status, String modBy,
			Date modOn) {
		super();
		this.practiceId = practiceId;
		this.practiceName = practiceName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	@Override
	public String toString() {
		return "PracticeMaster [practiceId=" + practiceId + ", practiceName=" + practiceName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", status=" + status + ", modBy=" + modBy + ", modOn=" + modOn + "]";
	}
	
	

}
