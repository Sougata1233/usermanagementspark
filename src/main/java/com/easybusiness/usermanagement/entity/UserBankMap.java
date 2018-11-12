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
import javax.persistence.Table;

@Entity
@Table(name = "USER_BANK_MAP_MASTER")
public class UserBankMap implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5300599187745769139L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @Column(name = "ACCOUNT_NO")
    private String accountNum;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    public UserBankMap() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Bank getBank() {
	return bank;
    }

    public void setBank(Bank bank) {
	this.bank = bank;
    }

    public Branch getBranch() {
	return branch;
    }

    public void setBranch(Branch branch) {
	this.branch = branch;
    }

    public String getAccountNum() {
	return accountNum;
    }

    public void setAccountNum(String accountNum) {
	this.accountNum = accountNum;
    }

    public String getIfscCode() {
	return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
	return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
	return "UserBankMap [id=" + id + ", user=" + user + ", bank=" + bank + ", branch=" + branch + ", accountNum="
		+ accountNum + ", ifscCode=" + ifscCode + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
		+ ", accountType=" + accountType + "]";
    }


}
