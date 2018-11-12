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
@Table(name = "MENU_MASTER")
public class Menu implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    @Id
    @Column(name = "MENU_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MENU")
    private String menuName;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedTime;
    
    @Column(name = "MENU_ICON_NAME")
    private String menuIconName;

    public Menu() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getMenuName() {
	return menuName;
    }

    public void setMenuName(String menuName) {
	this.menuName = menuName;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
	return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
	this.modifiedTime = modifiedTime;
    }

    public String getMenuIconName() {
        return menuIconName;
    }

    public void setMenuIconName(String menuIconName) {
        this.menuIconName = menuIconName;
    }

    @Override
    public String toString() {
	return "Menu [id=" + id + ", menuName=" + menuName + ", modifiedBy=" + modifiedBy + ", modifiedTime="
		+ modifiedTime + ", menuIconName=" + menuIconName + "]";
    }


}
