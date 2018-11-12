package com.easybusiness.usermanagement.DTO;

public class CountryDTO {

	private long id;
	private String countryName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public CountryDTO(long id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}
	public CountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
