package com.easybusiness.usermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESIGNATION")
public class Designation {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "DESIG")
    private String desig;
    
    @Column(name="MOD_BY")
    private String modBy;
    
    @Column(name="MOD_ON")
    private Date modOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public Designation(long id, String desig, String modBy, Date modOn) {
		super();
		this.id = id;
		this.desig = desig;
		this.modBy = modBy;
		this.modOn = modOn;
	}

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", desig=" + desig + ", modBy=" + modBy + ", modOn=" + modOn + "]";
	}
    
    
	
}
