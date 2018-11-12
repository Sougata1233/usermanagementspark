package com.easybusiness.usermanagement.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "CITY_MASTER")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "CITY_SEQ", allocationSize = 1)
    private long id;

 
    @ManyToOne(cascade = {  },fetch = FetchType.EAGER)
    @JoinColumn(name = "STATE_ID",insertable = false, updatable = false)
    private State state;
   
    
    @Column(name = "STATE_ID")
    private int stateId;
    

    @Column(name = "CITY_NAME")
    private String cityName;
    

    public City() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }
    
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
	
    public int getstateId() {
       	return stateId;
           }

           public void setstateId(int stateId) {
       	        this.stateId = stateId;
           }



    public String getcityName() {
	return cityName;
    }

    public void setcityName(String cityName) {
	this.cityName = cityName;
    }

    
    @Override
    public String toString() {
	return "CITY [id=" + id + ",stateId="  + ", cityName=" + cityName +  "]";
    }

    

   

}

