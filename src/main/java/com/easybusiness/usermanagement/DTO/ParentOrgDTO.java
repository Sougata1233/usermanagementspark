package com.easybusiness.usermanagement.DTO;

import java.util.List;

import com.easybusiness.usermanagement.entity.Organization;

public class ParentOrgDTO {
	
	private Organization parentOrg;
	private OrgDTO org;
	public Organization getParentOrg() {
		return parentOrg;
	}
	public void setParentOrg(Organization parentOrg) {
		this.parentOrg = parentOrg;
	}
	public OrgDTO getOrg() {
		return org;
	}
	public void setOrg(OrgDTO orgDtos) {
		this.org = orgDtos;
	}
	public ParentOrgDTO(Organization parentOrg, OrgDTO org) {
		super();
		this.parentOrg = parentOrg;
		this.org = org;
	}
	public ParentOrgDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ParentOrgDTO [parentOrg=" + parentOrg + ", org=" + org + "]";
	}
	
	

}
