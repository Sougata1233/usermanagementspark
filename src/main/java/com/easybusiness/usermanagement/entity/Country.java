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
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "COUNTRY_MASTER")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "COUNTRY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
    private long id;
    
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID")
    private List<State> states;*/
    
    @OneToMany(mappedBy="country",fetch = FetchType.EAGER)
    private List<State> states;
    
    
    public List<State> getState() {
        return states;
    }

    public void setState(List<State> states) {
        this.states = states;
    }
    

    public String getcountryName() {
    	return countryName;
        }

        public void setcountryName(String countryName) {
    	this.countryName = countryName;
        }
    
 
    
    
    
    public Country() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }
    
    
   

    

    
    @Override
    public String toString() {
	return "Country [states="+states+", countryName=" + countryName +  ",id="+id+"]";
    }

    

   

}

