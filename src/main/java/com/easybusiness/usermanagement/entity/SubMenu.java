package com.easybusiness.usermanagement.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBMENU_MASTER")
public class SubMenu implements Serializable {

    private static final long serialVersionUID = -5612645047508536363L;

    @Id
    @Column(name = "SUB_MENU_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    @Column(name = "SUB_MENU")
    private String subMenu;

    @Column(name = "MOD_ON")
    private Date modifiedTime;
    
    @Column(name = "MOD_BY")
    private String modifiedBy;

    public SubMenu() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public String toString() {
	return "SubMenu [id=" + id + ", menu=" + menu + ", subMenu=" + subMenu + ", modifiedTime=" + modifiedTime
		+ ", modifiedBy=" + modifiedBy + "]";
    }

    

}
