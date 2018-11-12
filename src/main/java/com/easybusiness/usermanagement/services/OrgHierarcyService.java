package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.ParentOrgDTO;
import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;

public interface OrgHierarcyService {

	public ResponseEntity<UserHierarcyDTO> getHierarcyById(Long id);
	
	public UserHierarcyDTO persistHierarcy(UserHierarcyDTO hierarcy);
	
	public List<UserHierarcyDTO> populateHierarcyList();
	
	public void destroyHierarcy(long id);
	
	public UserHierarcyDTO updateHierarcy(long hierarcyId, UserHierarcyDTO hierarchyDTO);
	
	public ParentOrgDTO groupHead() ;
	
//	public List<GroupHeadDTO> groupHead() ;
	
//	public List<JsonNode> getHierarchy();
	
	
	
}
