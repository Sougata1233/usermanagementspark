package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class PriSupervisorDTO {
	
	private UserDTO priSupervisor;
	private List<PrjSupervisorDTO> prjSupervisor;
	
	public UserDTO getPriSupervisor() {
		return priSupervisor;
	}
	public void setPriSupervisor(UserDTO priSupervisor) {
		this.priSupervisor = priSupervisor;
	}
	public List<PrjSupervisorDTO> getPrjSupervisor() {
		return prjSupervisor;
	}
	public void setPrjSupervisor(List<PrjSupervisorDTO> prjSupervisorList) {
		this.prjSupervisor = prjSupervisorList;
	}
	public PriSupervisorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PriSupervisorDTO(UserDTO priSupervisor, List<PrjSupervisorDTO> prjSupervisor) {
		super();
		this.priSupervisor = priSupervisor;
		this.prjSupervisor = prjSupervisor;
	}
	@Override
	public String toString() {
		return "PriSupervisorDTO [priSupervisor=" + priSupervisor + ", prjSupervisor=" + prjSupervisor + "]";
	}
	
	

}
