package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "BANK_MASTER")
public class Bank {

    @Id
    @Column(name = "BANK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "Address")
    private String address;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;

    public Bank() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
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

    @Override
    public String toString() {
	return "Bank [id=" + id + ", bankName=" + bankName + ", location=" + location + ", address=" + address
		+ ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
    }

}
