package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.UserRoleMapDTO;

public interface UserRoleMappingService {

    public List<UserRoleMapDTO> getUserRoleByUserId(Long userId);

    public ResponseEntity<UserRoleMapDTO> getUserRoleByMappingId(Long mappingId);

    public List<UserRoleMapDTO> getUserRoleByRoleId(Long roleId);

    public ResponseEntity<UserRoleMapDTO> persistUserRoleMapping(UserRoleMapDTO userRoleMapDTO);

    public void destroyUserRoleMapping(Long userRoleMappingId);

    public List<UserRoleMapDTO> getFieldEq(final Class<UserRoleMapDTO> type, final String propertyName,
	    final Object value, int offset, int size);

}
