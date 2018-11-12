package com.easybusiness.usermanagement.DTO;

import java.util.List;

public class OrgHeadDTO {

	private UserDTO orgHead;
	private List<HrManagerDTO> hrManager;
	
	
	public UserDTO getOrgHead() {
		return orgHead;
	}
	public void setOrgHead(UserDTO userDTO) {
		this.orgHead = userDTO;
	}
	public List<HrManagerDTO> getHrManager() {
		return hrManager;
	}
	public void setHrManager(List<HrManagerDTO> hrManagerList) {
		this.hrManager = hrManagerList;
	}
	public OrgHeadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrgHeadDTO(UserDTO orgHead, List<HrManagerDTO> hrManager) {
		super();
		this.orgHead = orgHead;
		this.hrManager = hrManager;
	}
	@Override
	public String toString() {
		return "OrgHeadDTO [orgHead=" + orgHead + ", hrManager=" + hrManager + "]";
	}
	
	
	
}
