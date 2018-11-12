package com.easybusiness.usermanagement.DTO;

public class CityDTO {
	
	private long id;
	private String cityName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public CityDTO(long id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}
	public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
