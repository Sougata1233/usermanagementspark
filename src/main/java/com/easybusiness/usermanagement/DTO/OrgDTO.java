package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.Organization;

public class OrgDTO {
	
	private Organization org;
	
	private List<GroupHeadDTO> groupHead;

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public List<GroupHeadDTO> getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(List<GroupHeadDTO> groupheads) {
		this.groupHead = groupheads;
	}

	public OrgDTO(Organization org, List<GroupHeadDTO> groupHead) {
		super();
		this.org = org;
		this.groupHead = groupHead;
	}

	public OrgDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrgDTO [org=" + org + ", groupHead=" + groupHead + "]";
	}
	
	

}
