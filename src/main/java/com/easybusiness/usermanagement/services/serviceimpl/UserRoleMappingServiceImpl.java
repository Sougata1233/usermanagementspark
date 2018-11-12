package com.easybusiness.usermanagement.services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.RoleDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserRoleMapDTO;
import com.easybusiness.usermanagement.dao.RoleDao;
import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.dao.UserRoleMapDao;
import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Designation;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.Role;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserRoleMap;
import com.easybusiness.usermanagement.services.UserRoleMappingService;


/*
 * Service and RestController class for USER_ROLE_MAP_MASTER
 */
@Service
public class UserRoleMappingServiceImpl implements UserRoleMappingService {

    @Autowired
    UserRoleMapDao userRoleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertorole.UserRoleMappingService#getUserRoleByUserId(java.lang.Long)
     * fetching UserRoleMap by userid
     * GET method for USER_ROLE_MAP_MASTER table with param userid
     */
    @Override
    public List<UserRoleMapDTO> getUserRoleByUserId(Long userId) {

	User user = userDao.findUserById(userId);
	List<UserRoleMap> userRoleMapList = userRoleDao.findByUser(user);
	List<UserRoleMapDTO> userRoleMapDtoList = new ArrayList<UserRoleMapDTO>();
	userRoleMapList.forEach(userRoleMapEntity -> {

	    UserRoleMapDTO userRoleMapDTO = new UserRoleMapDTO();
	    userRoleMapDTO = prepareUserRoleMapDTO(userRoleMapEntity);
	    userRoleMapDtoList.add(userRoleMapDTO);
	});

	return userRoleMapDtoList;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertorole.UserRoleMappingService#getUserRoleByRoleId(java.lang.Long)
     * fetching UserRoleMap by roleid
     * GET method for USER_ROLE_MAP_MASTER table with param roleid
     */
    @Override
    public List<UserRoleMapDTO> getUserRoleByRoleId(Long roleId) {

	Role role = roleDao.findRoleById(roleId).get();
	List<UserRoleMap> userRoleMapList = userRoleDao.findByRole(role);
	List<UserRoleMapDTO> userRoleMapDtoList = new ArrayList<UserRoleMapDTO>();
	userRoleMapList.forEach(userRoleMapEntity -> {

	    UserRoleMapDTO userRoleMapDTO = new UserRoleMapDTO();
	    userRoleMapDTO = prepareUserRoleMapDTO(userRoleMapEntity);
	    userRoleMapDtoList.add(userRoleMapDTO);
	});

	return userRoleMapDtoList;

    }

    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertorole.UserRoleMappingService#getUserRoleByMappingId(java.lang.Long)
     * fetching UserRoleMap by mappingid
     * GET method for USER_ROLE_MAP_MASTER table with param mappingid
     */
    @Override
    public ResponseEntity<UserRoleMapDTO> getUserRoleByMappingId(Long mappingId) {

	UserRoleMap userRoleMap = userRoleDao.findUserRoleMapById(mappingId).get();
	return new ResponseEntity<UserRoleMapDTO>(prepareUserRoleMapDTO(userRoleMap), HttpStatus.FOUND);
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertorole.UserRoleMappingService#persistUserRoleMapping(com.easybusiness.usermanagement.DTO.UserRoleMapDTO)
     * mapping User to Role
     * POST method for USER_ROLE_MAP_MASTER table with UserRoleMapDTO request body
     */
    @Override
    public ResponseEntity<UserRoleMapDTO> persistUserRoleMapping(UserRoleMapDTO userRoleMapDTO) {

	UserRoleMap userRoleMapEntity = new UserRoleMap();
	userRoleMapEntity.setFromDate(userRoleMapDTO.getFromDate());
	userRoleMapEntity.setIsEnable(userRoleMapDTO.getIsEnable());
	userRoleMapEntity.setModifiedBy(userRoleMapDTO.getModifiedBy());
	userRoleMapEntity.setModifiedOn(userRoleMapDTO.getModifiedOn());
	userRoleMapEntity.setToDate(userRoleMapDTO.getToDate());
	User userEntity = prepareUserEntity(userRoleMapDTO);
	userRoleMapEntity.setUser(userEntity);
	Role role = prepareRoleEntity(userRoleMapDTO);
	userRoleMapEntity.setRole(role);
	userRoleDao.addUserRoleMap(userRoleMapEntity);
	return new ResponseEntity<UserRoleMapDTO>(userRoleMapDTO, HttpStatus.CREATED);

    }

    /*
     * preparing RoleEntity from UserRoelMapDTO
     */
    private Role prepareRoleEntity(UserRoleMapDTO userRoleMapDTO) {
	Role role = new Role();
	role.setFromDate(userRoleMapDTO.getRole().getFromDate());
	role.setId(userRoleMapDTO.getRole().getId());
	role.setIsEnable(userRoleMapDTO.getRole().getIsEnable());
	role.setModifiedBy(userRoleMapDTO.getRole().getModifiedBy());
	role.setModifiedOn(userRoleMapDTO.getRole().getModifiedOn());
	role.setRole(userRoleMapDTO.getRole().getRole());
	role.setToDate(userRoleMapDTO.getRole().getToDate());
	return role;
    }

    
    /*
     * preparing UserEntity from UserRoleMapDTO
     */
    private User prepareUserEntity(UserRoleMapDTO userRoleMapDTO) {
	User userEntity = new User();
	userEntity.setAlternateEmail(userRoleMapDTO.getUser().getAlternateEmail());
	userEntity.setDateOfBirth(userRoleMapDTO.getUser().getDateOfBirth());
	Department dept = new Department();
	dept.setDeptName(userRoleMapDTO.getUser().getDepartment().getDeptName());
	dept.setId(userRoleMapDTO.getUser().getDepartment().getId());
	Organization org = new Organization();
	org.setId(userRoleMapDTO.getUser().getDepartment().getOrganization().getId());
	org.setHierarchyId(userRoleMapDTO.getUser().getDepartment().getOrganization().getHierarchyId());
	org.setOrgName(userRoleMapDTO.getUser().getDepartment().getOrganization().getOrgName());
	dept.setOrganization(org);
	userEntity.setDepartment(dept);
	Designation desg = new Designation();
	desg.setDesig(userRoleMapDTO.getUser().getDesignation().getDesig());
	desg.setId(userRoleMapDTO.getUser().getDesignation().getId());
	userEntity.setDesignation(desg);
	userEntity.setEmail(userRoleMapDTO.getUser().getEmail());
	userEntity.setEndDate(userRoleMapDTO.getUser().getEndDate());
	userEntity.setFirstName(userRoleMapDTO.getUser().getFirstName());
	userEntity.setFromDate(userRoleMapDTO.getUser().getFromDate());
	userEntity.setGender(userRoleMapDTO.getUser().getGender());
	userEntity.setIsEnabled(userRoleMapDTO.getUser().getIsEnabled());
	userEntity.setLastName(userRoleMapDTO.getUser().getLastName());
	userEntity.setMobile(userRoleMapDTO.getUser().getMobile());
	userEntity.setModifiedBy(userRoleMapDTO.getUser().getModifiedBy());
	userEntity.setModifiedOn(userRoleMapDTO.getUser().getModifiedOn());
	userEntity.setOrganization(org);
	userEntity.setPassword(userRoleMapDTO.getUser().getPassword().toString());
	userEntity.setPermAddr(userRoleMapDTO.getUser().getPermAddr());
	userEntity.setState(userRoleMapDTO.getUser().getState());
	userEntity.setCity(userRoleMapDTO.getUser().getCity());
	userEntity.setCountry(userRoleMapDTO.getUser().getCountry());
	userEntity.setZip(userRoleMapDTO.getUser().getZip());
	userEntity.setFatherName(userRoleMapDTO.getUser().getFatherName());
	userEntity.setSpouseName(userRoleMapDTO.getUser().getSpouseName());
	userEntity.setPassport(userRoleMapDTO.getUser().getPassport());

	userEntity.setUserName(userRoleMapDTO.getUser().getUserName());
	userEntity.setId(userRoleMapDTO.getUser().getId());
	userEntity.setLocation(null == userRoleMapDTO.getUser().getLocation() ? null
		: prepareLocationEntity(userRoleMapDTO.getUser().getLocation()));
	

	return userEntity;
    }

    
    /*
     * preparing LocationEntity from LocationMasterDTO
     */
    private LocationMaster prepareLocationEntity(LocationMasterDTO location) {
	LocationMaster locationMaster = new LocationMaster();
	locationMaster.setCreatedBy(location.getCreatedBy());
	locationMaster.setCreatedOn(location.getCreatedOn());
	locationMaster.setId(location.getId());
	locationMaster.setLocationArea(location.getLocationArea());
	locationMaster.setLocationCity(location.getLocationCity());
	locationMaster.setLocationCountry(location.getLocationCountry());
	locationMaster.setLocationPin(location.getLocationPin());
	locationMaster.setLocationState(location.getLocationState());
	locationMaster.setModifiedBy(location.getModifiedBy());
	locationMaster.setModifiedOn(location.getModifiedOn());
	return locationMaster;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertorole.UserRoleMappingService#destroyUserRoleMapping(java.lang.Long)
     * Deleting user role map
     * DELETE method for USER_ROLE_MAP_MASTER table with param mappingid
     */
    @Override
    public void destroyUserRoleMapping(Long mappingId) {

	userRoleDao.deleteUserRoleMap(mappingId);
    }

    @Override
    public List<UserRoleMapDTO> getFieldEq(Class<UserRoleMapDTO> type, String propertyName, Object value, int offset,
	    int size) {
	return null;
    }

    /*
     * preparing UserRoleMapDTO from UserRoleMap entity
     */
    private UserRoleMapDTO prepareUserRoleMapDTO(UserRoleMap userRoleMapEntity) {
	UserRoleMapDTO userRoleMapDTO = new UserRoleMapDTO();
	userRoleMapDTO.setFromDate(userRoleMapEntity.getFromDate());
	userRoleMapDTO.setId(userRoleMapEntity.getId());
	userRoleMapDTO.setIsEnable(userRoleMapEntity.getIsEnable());
	userRoleMapDTO.setModifiedOn(userRoleMapEntity.getModifiedOn());
	userRoleMapDTO.setModifiedBy(userRoleMapEntity.getModifiedBy());

	RoleDTO roleDTO = prepareRoleDTO(userRoleMapEntity);

	userRoleMapDTO.setRole(roleDTO);
	userRoleMapDTO.setToDate(userRoleMapEntity.getToDate());
	userRoleMapDTO.setUser(prepareUserDTO(userRoleMapEntity.getUser()));
	return userRoleMapDTO;
    }

    /*
     * preparing RoleDTO from UserRoleMap entity
     */
    private RoleDTO prepareRoleDTO(UserRoleMap userRoleMapEntity) {
	RoleDTO roleDTO = new RoleDTO();
	roleDTO.setFromDate(userRoleMapEntity.getRole().getFromDate());
	roleDTO.setId(userRoleMapEntity.getRole().getId());
	roleDTO.setIsEnable(userRoleMapEntity.getRole().getIsEnable());
	roleDTO.setModifiedBy(userRoleMapEntity.getRole().getModifiedBy());
	roleDTO.setModifiedOn(userRoleMapEntity.getRole().getModifiedOn());
	roleDTO.setRole(userRoleMapEntity.getRole().getRole());
	roleDTO.setToDate(userRoleMapEntity.getRole().getToDate());
	return roleDTO;
    }

    /*
     * preparing UserDTO from User entity
     */
    private UserDTO prepareUserDTO(User userEntity) {
	UserDTO userDTO = new UserDTO();
	userDTO.setAlternateEmail(userEntity.getAlternateEmail());
	userDTO.setDateOfBirth(userEntity.getDateOfBirth());
	DepartmentDto deptDO = new DepartmentDto();
	deptDO.setDeptName(userEntity.getDepartment().getDeptName());
	deptDO.setId(userEntity.getDepartment().getId());
	OrganizationDto orgDTO = new OrganizationDto();
	orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
	orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
	orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
	deptDO.setOrganization(orgDTO);
	userDTO.setDepartment(deptDO);
	DesignationDto desigDTO = new DesignationDto();
	desigDTO.setDesig(userEntity.getDesignation().getDesig());
	desigDTO.setId(userEntity.getDesignation().getId());
	userDTO.setDesignation(desigDTO);
	userDTO.setEmail(userEntity.getEmail());
	userDTO.setEndDate(userEntity.getEndDate());
	userDTO.setFirstName(userEntity.getFirstName());
	userDTO.setFromDate(userEntity.getFromDate());
	userDTO.setGender(userEntity.getGender());
	userDTO.setId(userEntity.getId());
	userDTO.setIsEnabled(userEntity.getIsEnabled());
	userDTO.setLastName(userEntity.getLastName());
	userDTO.setMobile(userEntity.getMobile());
	userDTO.setModifiedBy(userEntity.getModifiedBy());
	userDTO.setModifiedOn(userEntity.getModifiedOn());
	userDTO.setOrganization(orgDTO);
	userDTO.setPassword(userEntity.getPassword());
	userDTO.setUserName(userEntity.getUserName());

	userDTO.setPermAddr(userEntity.getPermAddr());
	userDTO.setState(userEntity.getState());
	userDTO.setCity(userEntity.getCity());
	userDTO.setCountry(userEntity.getCountry());
	userDTO.setZip(userEntity.getZip());
	userDTO.setFatherName(userEntity.getFatherName());
	userDTO.setSpouseName(userEntity.getSpouseName());
	userDTO.setPassport(userEntity.getPassport());
	userDTO.setLocation(null == userEntity.getLocation() ? null : prepareLocationDTO(userEntity.getLocation()));
	
	return userDTO;
    }

    /*
     * preparing LocationMasterDTO from LocationMaster entity
     */
    private LocationMasterDTO prepareLocationDTO(LocationMaster location) {
	LocationMasterDTO locationMaster = new LocationMasterDTO();
	locationMaster.setCreatedBy(location.getCreatedBy());
	locationMaster.setCreatedOn(location.getCreatedOn());
	locationMaster.setId(location.getId());
	locationMaster.setLocationArea(location.getLocationArea());
	locationMaster.setLocationCity(location.getLocationCity());
	locationMaster.setLocationCountry(location.getLocationCountry());
	locationMaster.setLocationPin(location.getLocationPin());
	locationMaster.setLocationState(location.getLocationState());
	locationMaster.setModifiedBy(location.getModifiedBy());
	locationMaster.setModifiedOn(location.getModifiedOn());
	return locationMaster;
    }

}
