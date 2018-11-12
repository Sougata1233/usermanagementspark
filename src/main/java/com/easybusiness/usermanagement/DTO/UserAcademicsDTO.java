package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class UserAcademicsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long user;

    private String highestDegree;

    private String passingYear;

    private String university;
    
    private String isValid;
    
    private String modBy;
    
    private Date modOn;
    
    private String validity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
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

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public UserAcademicsDTO(Long id, Long user, String highestDegree, String passingYear, String university,
			String isValid, String modBy, Date modOn, String validity) {
		super();
		this.id = id;
		this.user = user;
		this.highestDegree = highestDegree;
		this.passingYear = passingYear;
		this.university = university;
		this.isValid = isValid;
		this.modBy = modBy;
		this.modOn = modOn;
		this.validity = validity;
	}

	public UserAcademicsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserAcademics [id=" + id + ", user=" + user + ", highestDegree=" + highestDegree + ", passingYear="
				+ passingYear + ", university=" + university + ", isValid=" + isValid + ", modBy=" + modBy + ", modOn="
				+ modOn + ", validity=" + validity + "]";
	}

    

}
