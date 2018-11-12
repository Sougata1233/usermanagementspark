package com.easybusiness.usermanagement.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_MASTER")
public class LocationMaster implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5300599187745769139L;

    @Id
    @Column(name = "LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOCATION_AREA")
    private String locationArea;

    @Column(name = "LOCATION_CITY")
    private String locationCity;

    @Column(name = "LOCATION_STATE")
    private String locationState;

    @Column(name = "LOCATION_COUNTRY")
    private String locationCountry;

    @Column(name = "LOCATION_PIN")
    private Long locationPin;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;

    public LocationMaster() {
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
