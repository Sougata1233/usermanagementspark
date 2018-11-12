package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.UserGroupDTO;

public interface UserGroupService {

    public ResponseEntity<UserGroupDTO> getUserGroupByName(String userGroupname);
    
    public ResponseEntity<UserGroupDTO> getUserGroupById(Long userGroupId);

    public ResponseEntity<UserGroupDTO> persistUserGroup(UserGroupDTO userGroupDTO);

    public List<UserGroupDTO> populateUserGroupList() throws Exception;

    public void destroyUserGroup(Long userGroupId);

    public List<UserGroupDTO> getFieldEq(final Class<UserGroupDTO> type, final String propertyName, final Object value, int offset,
	    int size);

    public void updateUserGroup(UserGroupDTO userGroupDto);

}
