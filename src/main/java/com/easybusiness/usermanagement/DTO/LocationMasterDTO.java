package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class LocationMasterDTO implements Serializable {

    private static final long serialVersionUID = -5300599187745769139L;

    private Long id;

    private String locationArea;

    private String locationCity;

    private String locationState;

    private String locationCountry;

    private Long locationPin;

    private String createdBy;

    private Date createdOn;

    private String modifiedBy;

    private Date modifiedOn;

    public LocationMasterDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getLocationArea() {
	return locationArea;
    }

    public void setLocationArea(String locationArea) {
	this.locationArea = locationArea;
    }

    public String getLocationCity() {
	return locationCity;
    }

    public void setLocationCity(String locationCity) {
	this.locationCity = locationCity;
    }

    public String getLocationState() {
	return locationState;
    }

    public void setLocationState(String locationState) {
	this.locationState = locationState;
    }

    public String getLocationCountry() {
	return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
	this.locationCountry = locationCountry;
    }

    public Long getLocationPin() {
	return locationPin;
    }

    public void setLocationPin(Long locationPin) {
	this.locationPin = locationPin;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
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
	return "LocationMaster [id=" + id + ", locationArea=" + locationArea + ", locationCity=" + locationCity
		+ ", locationState=" + locationState + ", locationCountry=" + locationCountry + ", locationPin="
		+ locationPin + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
		+ ", modifiedOn=" + modifiedOn + "]";
    }

}
