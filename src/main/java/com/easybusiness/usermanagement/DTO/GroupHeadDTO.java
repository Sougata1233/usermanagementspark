package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.UserHierarchy;

public class GroupHeadDTO {
	
	private UserDTO groupHead;
	private List<OrgHeadDTO> orgHeadList;
	
	
	
	public UserDTO getGroupHead() {
		return groupHead;
	}
	public void setGroupHead(UserDTO groupHeadEntity) {
		this.groupHead = groupHeadEntity;
	}
	public List<OrgHeadDTO> getOrgHeadList() {
		return orgHeadList;
	}
	public void setOrgHeadList(List<OrgHeadDTO> orgHeads) {
		this.orgHeadList = orgHeads;
	}
	public GroupHeadDTO(List<UserDTO> hierarcyList, List<OrgHeadDTO> orgHeadList) {
		super();
		this.orgHeadList = orgHeadList;
	}
	public GroupHeadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GroupHeadDTO [orgHeadList=" + orgHeadList + "]";
	}
	
	

}
