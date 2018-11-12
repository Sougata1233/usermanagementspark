package com.easybusiness.usermanagement.entity;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_EDUCATION")
public class UserAcademics implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_EDUCATION_SEQ")
    @SequenceGenerator(name="USER_EDUCATION_SEQ", sequenceName="USER_EDUCATION_SEQ")
    private Long id;

    @Column(name="USER_ID")
    private Long user;

    @Column(name = "COURSE_NAME")
    private String highestDegree;

    @Column(name = "PASSING_YEAR")
    private String passingYear;

    @Column(name = "UNIVERSITY")
    private String university;
    
    @Column(name="IS_VALID")
    private String isValid;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;
    
    @Column(name="VALIDITY")
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

	public UserAcademics(Long id, Long user, String highestDegree, String passingYear, String university,
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

	public UserAcademics() {
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
