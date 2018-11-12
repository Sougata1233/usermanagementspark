package com.easybusiness.usermanagement.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STATE_MASTER")
public class State implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "STATE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "STATE_SEQ", allocationSize = 1)
    private long id;

    /*@ManyToOne(cascade = { },fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID",insertable = false, updatable = false)
    private Country country;*/
    
    @ManyToOne(cascade = { },fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID",insertable = false, updatable = false)
    private Country country;
    
    @Column(name = "COUNTRY_ID")
    private int countryId;
    

    @Column(name = "STATE_NAME")
    private String stateName;
   
	@OneToMany(mappedBy="state",fetch = FetchType.EAGER)
//	@JoinColumn(name = "STATE_ID")
	private List<City> cities;
    
 
    public State() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }
    
    
    public List<City> getCity() {
        return cities;
    }

    public void setCity(List<City> cities) {
        this.cities = cities;
    }
    
    
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
   
    public int getcountryId() {
    	return countryId;
        }

        public void setcountryId(int countryId) {
    	this.countryId = countryId;
        }
    
 
    
     
	


    public String getstateName() {
	return stateName;
    }

    public void setstateName(String stateName) {
	this.stateName = stateName;
    }

    
    @Override
    public String toString() {
	return "State [id=" + id + ",country=" + countryId + ", stateName=" + stateName +  "]";
    }

    

   

}

