package com.easybusiness.usermanagement.DTO;

public class StateDTO {
	
	private long id;
	private String stateName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public StateDTO(long id, String stateName) {
		super();
		this.id = id;
		this.stateName = stateName;
	}
	public StateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StateDTO [id=" + id + ", stateName=" + stateName + "]";
	}
	
	

}
