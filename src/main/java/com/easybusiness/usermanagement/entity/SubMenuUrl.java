package com.easybusiness.usermanagement.entity;

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

@Entity
@Table(name = "SUBMENU_URL_MAP")
public class SubMenuUrl implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    @Id
    @Column(name = "MAPPING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SUB_MENU_ID")
    private SubMenu subMenu;


    @Column(name = "URL")
    private String url;
    
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    @Column(name = "CREATED_ON")
    private Date createdOn;

    public SubMenuUrl() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(SubMenu subMenu) {
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
