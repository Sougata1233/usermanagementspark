package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class PrjSupervisorDTO {
	
	private UserDTO prjSupervisor;
	private List<UserHDTO> user;
	
	public UserDTO getPrjSupervisor() {
		return prjSupervisor;
	}
	public void setPrjSupervisor(UserDTO prjSupervisor) {
		this.prjSupervisor = prjSupervisor;
	}
	public List<UserHDTO> getUser() {
		return user;
	}
	public void setUser(List<UserHDTO> userList) {
		this.user = userList;
	}
	public PrjSupervisorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrjSupervisorDTO(UserDTO prjSupervisor, List<UserHDTO> user) {
		super();
		this.prjSupervisor = prjSupervisor;
		this.user = user;
	}
	@Override
	public String toString() {
		return "PrjSupervisorDTO [prjSupervisor=" + prjSupervisor + ", user=" + user + "]";
	}
	
	

}
