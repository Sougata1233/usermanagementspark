package com.easybusiness.usermanagement.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Table(name = "USER_DETAILS")
@Embeddable
public class User implements Serializable {
    
   private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_DETAILS_SEQ")
    @SequenceGenerator(name="USER_DETAILS_SEQ", sequenceName="USER_DETAILS_SEQ")
    private Long id;

    @Column(name = "USER_LOGIN_ID")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DOB")
    private Date dateOfBirth;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ALTR_EMAIL")
    private String alternateEmail;

    @Column(name = "MOBILE")
    private Long mobile;

    @Column(name = "END_DATE")
    private Date endDate;

    @OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "ORGANIZATION")
    private Organization organization;

    @OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT")
    private Department department;
    
    @OneToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "DESIGNATION")
    private Designation designation;

    @Column(name = "TYPE_OF_EMP")
    private String typeOfEmployment;

    @Column(name = "IS_ENABLE")
    private Long isEnabled;

    @Column(name = "USER_IMG")
    private Blob userImg;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_DT")
    private Date modifiedOn;
    
    @Column(name = "PERM_ADDR")
    private String permAddr;

    /*@ManyToOne
    @JoinColumn(name="STATE",insertable = false, updatable = false)
    private State state;*/
    
    @Column(name = "STATE")
    private String state;
    
    /*@ManyToOne
    @JoinColumn(name="CITY")
    private City city;*/
    
    @Column(name = "CITY")
    private String city;
    
    /*@ManyToOne
    @JoinColumn(name="COUNTRY")
    private Country country;*/
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "ZIP")
    private String zip;
    
    @Column(name = "FATHER")
    private String fatherName;
    
    @Column(name = "SPOUSE")
    private String spouseName;
    
    @Column(name = "PASSPORT")
    private String passport;
    
    @ManyToOne(cascade = { CascadeType.MERGE },fetch= FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private LocationMaster location;
    
    @Column(name="EPF_NO")
    private String epfNo;
    
    @Column(name="ESI_NO")
    private String esiNo;
    
    
    
    
    
    
	/*public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}*/

	public String getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}

	public User() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public Date getFromDate() {
	return fromDate;
    }

    public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public Date getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getAlternateEmail() {
	return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
	this.alternateEmail = alternateEmail;
    }

    public Long getMobile() {
	return mobile;
    }

    public void setMobile(Long mobile) {
	this.mobile = mobile;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public String getTypeOfEmployment() {
	return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
	this.typeOfEmployment = typeOfEmployment;
    }

    public Long getIsEnabled() {
	return isEnabled;
    }

    public void setIsEnabled(Long isEnabled) {
	this.isEnabled = isEnabled;
    }

    public Blob getUserImg() {
	return userImg;
    }

    public void setUserImg(Blob userImg) {
	this.userImg = userImg;
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

    
    public String getPermAddr() {
        return permAddr;
    }

    public void setPermAddr(String permAddr) {
        this.permAddr = permAddr;
    }
    
    

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocationMaster getLocation() {
        return location;
    }

    public void setLocation(LocationMaster location) {
        this.location = location;
    }

    

    @Override
    public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", fromDate=" + fromDate
		+ ", lastName=" + lastName + ", password=" + password + ", gender=" + gender + ", dateOfBirth="
		+ dateOfBirth + ", email=" + email + ", alternateEmail=" + alternateEmail + ", mobile=" + mobile
		+ ", endDate=" + endDate + ", organization=" + organization + ", department=" + department
		+ ", designation=" + designation + ", typeOfEmployment=" + typeOfEmployment + ", isEnabled=" + isEnabled
		+ ", userImg=" + userImg + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + ", permAddr="
		+ permAddr + ", state=" + state + ", city=" + city + ", country=" + country + ", zip=" + zip
		+ ", fatherName=" + fatherName + ", spouseName=" + spouseName + ", passport=" + passport + ", location="
		+ location + "]";
    }


   
}
