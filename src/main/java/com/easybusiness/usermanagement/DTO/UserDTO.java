package com.easybusiness.usermanagement.DTO;

import java.sql.Date;
import java.util.Arrays;

import com.easybusiness.usermanagement.entity.City;
import com.easybusiness.usermanagement.entity.Country;
import com.easybusiness.usermanagement.entity.State;


public class UserDTO {

    private Long id;

    private String userName;

    private String firstName;

    private Date fromDate;

    private String lastName;

    private String password;

    private String gender;

    private Date dateOfBirth;

    private String email;

    private String alternateEmail;

    private Long mobile;

    private Date endDate;

    private OrganizationDto organization;

    private DepartmentDto department;

    private DesignationDto designation;

    private String typeOfEmployment;

    private Long isEnabled;

    private byte[] userImg;
    
    private String modifiedBy;

    private Date modifiedOn;

    private String permAddr;

    private String state;

    private String city;

    private String country;

    private String zip;

    private String fatherName;

    private String spouseName;

    private String passport;

    private LocationMasterDTO location;
    
    private String epfNo;
    
    private String esiNo;
    
    private CountryDTO countryName;
    private StateDTO stateName;
    private CityDTO cityName;
    
    
   

	public CountryDTO getCountryName() {
		return countryName;
	}



	public void setCountryName(CountryDTO countryName) {
		this.countryName = countryName;
	}



	public StateDTO getStateName() {
		return stateName;
	}



	public void setStateName(StateDTO stateName) {
		this.stateName = stateName;
	}



	public CityDTO getCityName() {
		return cityName;
	}



	public void setCityName(CityDTO cityName) {
		this.cityName = cityName;
	}



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



	public UserDTO() {
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

    public OrganizationDto getOrganization() {
	return organization;
    }

    public void setOrganization(OrganizationDto organization) {
	this.organization = organization;
    }

    public DepartmentDto getDepartment() {
	return department;
    }

    public void setDepartment(DepartmentDto department) {
	this.department = department;
    }

    public DesignationDto getDesignation() {
	return designation;
    }

    public void setDesignation(DesignationDto designation) {
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

    public byte[] getUserImg() {
	return userImg;
    }

    public void setUserImg(byte[] userImg) {
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

    public LocationMasterDTO getLocation() {
        return location;
    }

    public void setLocation(LocationMasterDTO location) {
        this.location = location;
    }

    

    @Override
    public String toString() {
	return "UserDTO [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", fromDate=" + fromDate
		+ ", lastName=" + lastName + ", password=" + password + ", gender=" + gender + ", dateOfBirth="
		+ dateOfBirth + ", email=" + email + ", alternateEmail=" + alternateEmail + ", mobile=" + mobile
		+ ", endDate=" + endDate + ", organization=" + organization + ", department=" + department
		+ ", designation=" + designation + ", typeOfEmployment=" + typeOfEmployment + ", isEnabled=" + isEnabled
		+ ", userImg=" + Arrays.toString(userImg) + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
		+ ", permAddr=" + permAddr + ", state=" + state + ", city=" + city + ", country=" + country + ", zip="
		+ zip + ", fatherName=" + fatherName + ", spouseName=" + spouseName + ", passport=" + passport
		+ ", location=" + location + "]";
    }

	
	
}
