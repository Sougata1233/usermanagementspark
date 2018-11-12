package com.easybusiness.usermanagement.services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.RoleDTO;
import com.easybusiness.usermanagement.dao.RoleDao;
import com.easybusiness.usermanagement.entity.Role;
import com.easybusiness.usermanagement.services.RoleService;


/*
 * Service and RestController class for ROLE_DETAILS table
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.role.RoleService#getRoleByName(java.lang.String)
     * fetching roles by rolename
     * GET method for ROLE_DETAILS table with param rolename
     */
    @Override
    public RoleDTO getRoleByName(String roleName) {

	Role role = roleDao.findByRoleName(roleName.toUpperCase());
	return prepareRoleDetails(role);
    }

    
    /*
     * preparing RoleDTO from Role entity
     */
    private RoleDTO prepareRoleDetails(Role role) {
	RoleDTO roleDTO = new RoleDTO();
	roleDTO.setId(role.getId());
	roleDTO.setRole(role.getRole());
	roleDTO.setFromDate(role.getFromDate());
	roleDTO.setIsEnable(role.getIsEnable());
	roleDTO.setModifiedBy(role.getModifiedBy());
	roleDTO.setModifiedOn(role.getModifiedOn());
	roleDTO.setToDate(role.getToDate());
	return roleDTO;
    }

    @Override
    public List<RoleDTO> getRolesAsPerCriteria(String whereClause) {

	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.role.RoleService#addRole(com.easybusiness.usermanagement.DTO.RoleDTO)
     * saving role to database 
     * POST method for ROLE_DETAILS table with RoleDTO request body
     */
    @Override
    public ResponseEntity<RoleDTO> addRole(RoleDTO roleModel) {

	roleDao.addRole(prepareRoleEntity(roleModel));
	return new ResponseEntity<RoleDTO>(roleModel, HttpStatus.CREATED);

    }

    /*
     * preparing Role entity from RoleDTO
     */
    private Role prepareRoleEntity(RoleDTO roleDTO) {
	Role roleEntity = new Role();
	roleEntity.setRole(roleDTO.getRole());
	roleEntity.setFromDate(roleDTO.getFromDate());
	roleEntity.setIsEnable(roleDTO.getIsEnable());
	roleEntity.setModifiedBy(roleDTO.getModifiedBy());
	roleEntity.setModifiedOn(roleDTO.getModifiedOn());
	roleEntity.setToDate(roleDTO.getToDate());
	return roleEntity;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.role.RoleService#getAllRoles()
     * fetching all roles
     * GET method for ROLE_DETAILS table 
     */
    @Override
    public List<RoleDTO> getAllRoles() throws Exception {
	List<Role> roleList = roleDao.findAll();
	List<RoleDTO> roleModelList = new ArrayList<RoleDTO>();
	roleList.forEach(roleEntity -> {
	    RoleDTO roleModel = new RoleDTO();
	    roleModel = prepareRoleDetails(roleEntity);
	    roleModelList.add(roleModel);

	});
	return roleModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.role.RoleService#getRoleById(java.lang.Long)
     * fetching Roles by roleid
     * GET method for ROLE_DETAILS table with param roleid
     */
    @Override
    public RoleDTO getRoleById(Long roleId) {

	return prepareRoleDetails(roleDao.findRoleById(roleId).get());
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.role.RoleService#deleteRole(java.lang.Long)
     * deleting role by roleid
     * DELETE method for ROLE_DETAILS table with param roleid
     */
    @Override
    public ResponseEntity<RoleDTO> deleteRole(Long roleId) {

	// roleMenuDao.deleteRoleMenuByRoleId(roleId);
	Role role = roleDao.findRoleById(roleId).get();
	roleDao.deleteRole(roleId);
	return new ResponseEntity<RoleDTO>(prepareRoleDetails(role), HttpStatus.OK);

    }

    @Override
    public List<RoleDTO> getFieldEq(Class<RoleDTO> type, String propertyName, Object value, int offset, int size) {

	return null;
    }

}
