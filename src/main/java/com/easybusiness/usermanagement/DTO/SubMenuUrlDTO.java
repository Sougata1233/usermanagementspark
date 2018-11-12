package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class SubMenuUrlDTO implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    private Long id;

    private SubMenuDTO subMenu;

    private String url;
    
    private String createdBy;
    
    private Date createdOn;

    public SubMenuUrlDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public SubMenuDTO getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(SubMenuDTO subMenu) {
        this.subMenu = subMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
	return "SubMenuUrl [id=" + id + ", subMenu=" + subMenu + ", url=" + url + ", createdBy=" + createdBy
		+ ", createdOn=" + createdOn + "]";
    }



    

}
