package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.RoleDTO;

public interface RoleService {

    public RoleDTO getRoleByName(String roleName);

    public List<RoleDTO> getRolesAsPerCriteria(String whereClause);

    public ResponseEntity<RoleDTO> addRole(RoleDTO role);

    public List<RoleDTO> getAllRoles() throws Exception;

    public RoleDTO getRoleById(Long roleId);

    public ResponseEntity<RoleDTO> deleteRole(Long roleId);

    public List<RoleDTO> getFieldEq(final Class<RoleDTO> type, final String propertyName, final Object value,
	    int offset, int size);

}
