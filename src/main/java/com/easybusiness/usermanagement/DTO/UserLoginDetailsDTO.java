package com.easybusiness.usermanagement.DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class UserLoginDetailsDTO {

	private String loginToken;
	
	private long userId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private Date createDate;
	
	private Date lastModifiedDate;
	
	private String isActive;
	
	private long counter;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public UserLoginDetailsDTO(String loginToken, long userId, String userName, String firstName, String lastName,
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

	public UserLoginDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserLoginDetailsDTO [loginToken=" + loginToken + ", userId=" + userId + ", userLoginId=" + userName
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", isActive=" + isActive + ", counter=" + counter + "]";
	}
	
	
	
}
