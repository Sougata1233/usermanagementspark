package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.easybusiness.usermanagement.DTO.GroupHeadDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;
import com.easybusiness.usermanagement.entity.UserHierarchy;
import com.fasterxml.jackson.databind.JsonNode;

public interface UserHierarcyService {

	public ResponseEntity<UserHierarcyDTO> getHierarcyById(Long id);
	
	public UserHierarcyDTO persistHierarcy(UserHierarcyDTO hierarcy);
	
	public List<UserHierarcyDTO> populateHierarcyList();
	
	public void destroyHierarcy(long id);
	
	public UserHierarcyDTO updateHierarcy(long hierarcyId, UserHierarcyDTO hierarchyDTO);
	
	public GroupHeadDTO groupHead() ;
	
//	public List<GroupHeadDTO> groupHead() ;
	
//	public List<JsonNode> getHierarchy();
	
	
	
}
