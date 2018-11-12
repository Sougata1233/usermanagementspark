package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "BRANCH_MASTER")
public class Branch {

    @Id
    @Column(name = "BRANCH_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "Address")
    private String address;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "IFSC_CODE")
    private String ifscCode;

    public Branch() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Bank getBank() {
	return bank;
    }

    public void setBank(Bank bank) {
	this.bank = bank;
    }

    public String getBranchName() {
	return branchName;
    }

    public void setBranchName(String branchName) {
	this.branchName = branchName;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
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

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    @Override
    public String toString() {
	return "Branch [id=" + id + ", bank=" + bank + ", branchName=" + branchName + ", address=" + address
		+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + ", ifscCode=" + ifscCode + "]";
    }


}
