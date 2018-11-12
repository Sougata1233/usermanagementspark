package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.RoleActionMapDTO;

public interface RoleActionMappingService {

    public List<RoleActionMapDTO> getActionByRoleId(Long roleId);

    public ResponseEntity<RoleActionMapDTO> persistRoleActionMapping(RoleActionMapDTO roleActionMapDTO);

    public void destroyRoleActionMapping(Long roleActionMappingId);

    public List<RoleActionMapDTO> getFieldEq(final Class<RoleActionMapDTO> type, final String propertyName,
	    final Object value, int offset, int size);

}
