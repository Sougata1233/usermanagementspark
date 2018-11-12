package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.UserGroupMenuDTO;
import com.easybusiness.usermanagement.entity.UserGroupMenu;

public interface UserGroupMenuMappingService {

    public ResponseEntity<UserGroupMenuDTO> getUserGroupMenuBymappingId(Long mappingId);

    public List<UserGroupMenuDTO> getUserGroupMenuByGroupId(Long groupId);

    public List<UserGroupMenuDTO> getUserGroupMenuByMenuId(Long menuId);

    public ResponseEntity<UserGroupMenuDTO> persistUserGroupMenu(UserGroupMenuDTO UserGroupMenuDTO);

    public void destroyUserGroupMenu(Long userGroupMenuId);

    public List<UserGroupMenuDTO> getFieldEq(final Class<UserGroupMenuDTO> type, final String propertyName,
	    final Object value, int offset, int size);

    List<UserGroupMenuDTO> getUserGroupMenuByGroupName(String groupName);

}
