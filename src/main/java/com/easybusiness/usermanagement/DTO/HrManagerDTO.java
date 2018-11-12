package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class HrManagerDTO {
	
	private UserDTO hrManager;
	private List<PriSupervisorDTO> priSuperviser;
	
	public UserDTO getHrManager() {
		return hrManager;
	}
	public void setHrManager(UserDTO hrManager) {
		this.hrManager = hrManager;
	}
	public List<PriSupervisorDTO> getPriSuperviser() {
		return priSuperviser;
	}
	public void setPriSuperviser(List<PriSupervisorDTO> priSupervisorList) {
		this.priSuperviser = priSupervisorList;
	}
	public HrManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrManagerDTO(UserDTO hrManager, List<PriSupervisorDTO> priSuperviser) {
		super();
		this.hrManager = hrManager;
		this.priSuperviser = priSuperviser;
	}
	@Override
	public String toString() {
		return "HrManagerDTO [hrManager=" + hrManager + ", priSuperviser=" + priSuperviser + "]";
	}
	
	
	

}
