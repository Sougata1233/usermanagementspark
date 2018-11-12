package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_LOGIN_DETAILS")
public class UserLoginDetails {

	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LOGIN_TOKEN")
	private String loginToken;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="USER_LOGIN_ID")
	private String userName;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="COUNTER")
	private long counter;

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	public UserLoginDetails(String loginToken, long userId, String userName, String firstName, String lastName,
			Date createDate, Date lastModifiedDate, String isActive, long counter) {
		super();
		this.loginToken = loginToken;
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isActive = isActive;
		this.counter = counter;
	}

	public UserLoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserLoginDetails [loginToken=" + loginToken + ", userId=" + userName + ", userLoginId=" + userName
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", isActive=" + isActive + ", counter=" + counter + "]";
	}
	
	
	
}
