package com.easybusiness.usermanagement.services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserGroupDTO;
import com.easybusiness.usermanagement.DTO.UserGroupMapDTO;
import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.dao.UserGroupDao;
import com.easybusiness.usermanagement.dao.UserGroupMapDao;
import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Designation;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMap;
import com.easybusiness.usermanagement.services.UserGroupMappingService;

/*
 * Service and RestController for UserGroupMap
 */
@Service
public class UserGroupMappingServiceImpl implements UserGroupMappingService {

    @Autowired
    UserGroupMapDao userGroupMapDao;

    @Autowired
    UserGroupDao userGroupDao;

    @Autowired
    UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGroupMappingServiceImpl.class);

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#getUserGroupMapByGroupId(java.lang.Long)
     * fetching UserGroup by groupid
     * GET method for USER_GROUP_MAP_MASTER table with param usergroupid
     */
    @Override
    public List<UserGroupMapDTO> getUserGroupMapByGroupId(Long userGroupId) {

	UserGroup userGroupEntity = userGroupDao.findUserGroupById(userGroupId).get();
	List<UserGroupMap> userGroupMapEntityList = userGroupMapDao.findUserGroupMapByGroupId(userGroupEntity);
	List<UserGroupMapDTO> userGroupMapList = new ArrayList<UserGroupMapDTO>();
	
	userGroupMapEntityList.forEach(userGroupMapEntity -> {
	    UserGroupMapDTO userGroupMapDTO = prepareUserGroupMapDTO(userGroupMapEntity);
	    userGroupMapList.add(userGroupMapDTO);
	});

	return userGroupMapList;

    }

    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#getAllUsersOfGroup(java.lang.Long)
     * fetching UserGroup by usergroupid
     * GET method for USER_GROUP_MAP_MASTER table with param usergroupid
     */
    @Override
    public List<UserDTO> getAllUsersOfGroup(Long userGroupId) {

	UserGroup userGroupEntity = userGroupDao.findUserGroupById(userGroupId).get();
	List<UserGroupMap> userGroupMapEntityList = userGroupMapDao.findUserGroupMapByGroupId(userGroupEntity);
	List<UserDTO> userList = new ArrayList<UserDTO>();
	userGroupMapEntityList.forEach(userGroupMapEntity -> {
	    UserGroupMapDTO userGroupMapDTO = prepareUserGroupMapDTO(userGroupMapEntity);
	    if(userGroupMapDTO.getUser().getIsEnabled()==1){
	    	userList.add(userGroupMapDTO.getUser());
	    }
	});

	return userList;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#getAllUsersOfGroupByGroupName(java.lang.String)
     * Fetching UserGroup by usergroupname
     * GET method for USER_GROUP_MAP_MASTER table with param usergroupname
     */
    @Override
    public List<UserDTO> getAllUsersOfGroupByGroupName(String userGroupName) {

	UserGroup userGroupEntity = userGroupDao.findByUserGroupName(userGroupName);
	List<UserGroupMap> userGroupMapEntityList = userGroupMapDao.findUserGroupMapByGroupId(userGroupEntity);
	List<UserDTO> userList = new ArrayList<UserDTO>();
	userGroupMapEntityList.forEach(userGroupMapEntity -> {
	    UserGroupMapDTO userGroupMapDTO = prepareUserGroupMapDTO(userGroupMapEntity);
	    if(userGroupMapDTO.getUser().getIsEnabled()==1)
	    {
	    userList.add(userGroupMapDTO.getUser());
	    }
	});

	return userList;

    }

    
    /*
     * Preparing UserGroupMapDTO from UserGroupMap entity
     */
    private UserGroupMapDTO prepareUserGroupMapDTO(UserGroupMap userGroupMapEntity) {
	UserGroupMapDTO userGroupMapDTO = new UserGroupMapDTO();
	userGroupMapDTO.setFromDate(userGroupMapEntity.getFromDate());
	userGroupMapDTO.setId(userGroupMapEntity.getId());
	userGroupMapDTO.setIsEnable(userGroupMapEntity.getIsEnable());
	userGroupMapDTO.setModifiedBy(userGroupMapEntity.getModifiedBy());
	userGroupMapDTO.setModifiedOn(userGroupMapEntity.getModifiedOn());
	userGroupMapDTO.setToDate(userGroupMapEntity.getToDate());
	userGroupMapDTO.setUser(prepareUserDTO(userGroupMapEntity.getUser()));
	userGroupMapDTO.setUserGroup(prepareUserGroupDTO(userGroupMapEntity.getUserGroup()));
	return userGroupMapDTO;
    }

    
    /*
     * Preparing UserDTO from User Entity
     */
    private UserDTO prepareUserDTO(User userEntity) {
	UserDTO userDTO = new UserDTO();
	userDTO.setAlternateEmail(userEntity.getAlternateEmail());
	userDTO.setDateOfBirth(userEntity.getDateOfBirth());
	try {
	    DepartmentDto deptDO = new DepartmentDto();
	    deptDO.setDeptName(userEntity.getDepartment().getDeptName());
	    deptDO.setId(userEntity.getDepartment().getId());
	    OrganizationDto orgDTO = new OrganizationDto();
	    orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
	    orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
	    orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
	    deptDO.setOrganization(orgDTO);
	    userDTO.setDepartment(deptDO);
	    userDTO.setOrganization(orgDTO);
	} catch (Exception e) {
	    LOGGER.error("exception while getting organization/department details for user {} {}",
		    userEntity.getUserName(), e.getMessage());
	}
	try {
	    DesignationDto desigDTO = new DesignationDto();
	    desigDTO.setDesig(userEntity.getDesignation().getDesig());
	    desigDTO.setId(userEntity.getDesignation().getId());
	    userDTO.setDesignation(desigDTO);
	} catch (Exception e) {
	    LOGGER.error("exception while getting designation details for user {} {}", userEntity.getUserName(),
		    e.getMessage());
	}
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

	userDTO.setPassword(userEntity.getPassword());
	userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
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
     * Preparing LocationMasterDTO from LocationMaster entity
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

    /*
     * Preparing UserGroupDTO from UserGroupEntity
     */
    private UserGroupDTO prepareUserGroupDTO(UserGroup userGroupEntity) {
	UserGroupDTO userGroupDTO = new UserGroupDTO();
	userGroupDTO.setFromDate(userGroupEntity.getFromDate());
	userGroupDTO.setId(userGroupEntity.getId());
	userGroupDTO.setIsEnable(userGroupEntity.getIsEnable());
	userGroupDTO.setModifiedBy(userGroupEntity.getModifiedBy());
	userGroupDTO.setModifiedOn(userGroupEntity.getModifiedOn());
	userGroupDTO.setToDate(userGroupEntity.getToDate());
	userGroupDTO.setUserGroupName(userGroupEntity.getUserGroupName());
	return userGroupDTO;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#getUserGroupMapByUserId(java.lang.Long)
     * Fetching UserGroupMap by userid
     * GET method for USER_GROUP_MAP_MASTER table with param userid
     * this method maps with user details table and fetch the usergroup by userid
     */
    @Override
    public List<UserGroupMapDTO> getUserGroupMapByUserId(Long userId) {
	User userEntity = userDao.findUserById(userId);
	List<UserGroupMap> userGroupMapEntityList = userGroupMapDao.findByUser(userEntity);
	List<UserGroupMapDTO> userGroupMapList = new ArrayList<UserGroupMapDTO>();
	userGroupMapEntityList.forEach(userGroupMapEntity -> {
	    UserGroupMapDTO userGroupMapDTO = prepareUserGroupMapDTO(userGroupMapEntity);
	    userGroupMapList.add(userGroupMapDTO);
	});

	return userGroupMapList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#getUserGroupMapByMappingId(java.lang.Long)
     * Fetching UserGroupMap by mappingid
     * GET method for USER_GROUP_MAP_MASTER table with param mappingid
     */
    @Override
    public ResponseEntity<UserGroupMapDTO> getUserGroupMapByMappingId(Long mappingId) {

	UserGroupMap userGroupMap = userGroupMapDao.findUserGroupMapById(mappingId).get();
	return new ResponseEntity<UserGroupMapDTO>(prepareUserGroupMapDTO(userGroupMap), HttpStatus.FOUND);
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#persistUserGroupMapping(com.easybusiness.usermanagement.DTO.UserGroupMapDTO)
     * Mapping UserGroup to User
     * POST method for USER_GROUP_MAP_MASTER table with UserGroupMapDTO request body
     */
    @Override
    public ResponseEntity<UserGroupMapDTO> persistUserGroupMapping(UserGroupMapDTO userGroupMapDTO) {

	UserGroupMap userGroupMapEntity = new UserGroupMap();
	userGroupMapEntity.setFromDate(userGroupMapDTO.getFromDate());
	userGroupMapEntity.setIsEnable(userGroupMapDTO.getIsEnable());
	userGroupMapEntity.setModifiedBy(userGroupMapDTO.getModifiedBy());
	userGroupMapEntity.setModifiedOn(userGroupMapDTO.getModifiedOn());
	userGroupMapEntity.setToDate(userGroupMapDTO.getToDate());
	
//	User userEntity = prepareUserEntity(userGroupMapDTO);
	User userEntity = userDao.findUserById(userGroupMapDTO.getUser().getId());
	userGroupMapEntity.setUser(userEntity);
	
//	UserGroup userGroupEntity = prepareUserGroupEntity(userGroupMapDTO);
	UserGroup userGroupEntity = userGroupDao.findUserGroupById(userGroupMapDTO.getUserGroup().getId()).get();
	userGroupMapEntity.setUserGroup(userGroupEntity);
	
	UserGroupMap groupmap = userGroupMapDao.addUserGroupMap(userGroupMapEntity);
	userGroupMapDTO.setId(groupmap.getId());

	return new ResponseEntity<UserGroupMapDTO>(userGroupMapDTO, HttpStatus.CREATED);

    }

    /*
     * Preparing UserGroupMapDTO from UserGroupMap entity
     */
    private UserGroup prepareUserGroupEntity(UserGroupMapDTO userGroupMapDTO) {
	UserGroup userGroupEntity = new UserGroup();
	userGroupEntity.setFromDate(userGroupMapDTO.getUserGroup().getFromDate());
	userGroupEntity.setIsEnable(userGroupMapDTO.getUserGroup().getIsEnable());
	userGroupEntity.setModifiedBy(userGroupMapDTO.getUserGroup().getModifiedBy());
	userGroupEntity.setModifiedOn(userGroupMapDTO.getUserGroup().getModifiedOn());
	userGroupEntity.setToDate(userGroupMapDTO.getUserGroup().getToDate());
	userGroupEntity.setUserGroupName(userGroupMapDTO.getUserGroup().getUserGroupName());
	userGroupEntity.setId(userGroupMapDTO.getUserGroup().getId());
	return userGroupEntity;
    }

    
    /*
     * Preparing UserGroupMapDTO from UserGroupMap entity
     */
    private User prepareUserEntity(UserGroupMapDTO userGroupMapDTO) {
	User userEntity = new User();
	User user = userDao.findUserById(userGroupMapDTO.getUser().getId());
	userEntity.setAlternateEmail(userGroupMapDTO.getUser().getAlternateEmail());
	userEntity.setDateOfBirth(userGroupMapDTO.getUser().getDateOfBirth());
	try {
	    Department dept = new Department();
	    dept.setDeptName(userGroupMapDTO.getUser().getDepartment().getDeptName());
	    dept.setId(userGroupMapDTO.getUser().getDepartment().getId());
	    Organization org = new Organization();
	    org.setId(userGroupMapDTO.getUser().getDepartment().getOrganization().getId());
	    org.setHierarchyId(userGroupMapDTO.getUser().getDepartment().getOrganization().getHierarchyId());
	    org.setOrgName(userGroupMapDTO.getUser().getDepartment().getOrganization().getOrgName());
	    dept.setOrganization(org);
	    userEntity.setDepartment(dept);
	    userEntity.setOrganization(org);
	} catch (Exception e) {
	    LOGGER.error("exception in getting department/organization details for user {}{}",
		    userGroupMapDTO.getUser().getUserName(), e.getMessage());
	}
	try {
	    Designation desg = new Designation();
	    desg.setDesig(userGroupMapDTO.getUser().getDesignation().getDesig());
	    desg.setId(userGroupMapDTO.getUser().getDesignation().getId());
	    userEntity.setDesignation(desg);
	} catch (Exception e) {
	    LOGGER.error("exception in getting designation details for user {}{}",
		    userGroupMapDTO.getUser().getUserName(), e.getMessage());
	}
	userEntity.setEmail(userGroupMapDTO.getUser().getEmail());
	userEntity.setEndDate(userGroupMapDTO.getUser().getEndDate());
	userEntity.setFirstName(userGroupMapDTO.getUser().getFirstName());
	userEntity.setFromDate(userGroupMapDTO.getUser().getFromDate());
	userEntity.setGender(userGroupMapDTO.getUser().getGender());
	userEntity.setIsEnabled(userGroupMapDTO.getUser().getIsEnabled());
	userEntity.setLastName(userGroupMapDTO.getUser().getLastName());
	userEntity.setMobile(userGroupMapDTO.getUser().getMobile());
	userEntity.setModifiedBy(userGroupMapDTO.getUser().getModifiedBy());
	userEntity.setModifiedOn(userGroupMapDTO.getUser().getModifiedOn());

	userEntity.setPassword(user.getPassword());
	userEntity.setTypeOfEmployment(userGroupMapDTO.getUser().getTypeOfEmployment());
	userEntity.setPermAddr(userGroupMapDTO.getUser().getPermAddr());
	userEntity.setState(userGroupMapDTO.getUser().getState());
	userEntity.setCity(userGroupMapDTO.getUser().getCity());
	userEntity.setCountry(userGroupMapDTO.getUser().getCountry());
	userEntity.setZip(userGroupMapDTO.getUser().getZip());
	userEntity.setFatherName(userGroupMapDTO.getUser().getFatherName());
	userEntity.setSpouseName(userGroupMapDTO.getUser().getSpouseName());
	userEntity.setPassport(userGroupMapDTO.getUser().getPassport());
	userEntity.setUserName(userGroupMapDTO.getUser().getUserName());
	userEntity.setId(userGroupMapDTO.getUser().getId());
	userEntity.setLocation(null == userGroupMapDTO.getUser().getLocation() ? null
		: prepareLocationEntity(userGroupMapDTO.getUser().getLocation()));
	
	return userEntity;
    }

    
    /*
     * preparing LocationEntity from LocationDTO
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
     * @see com.easybusiness.usermanagement.services.usertogroup.UserGroupMappingService#destroyUserGroupMapping(java.lang.Long)
     * Deleting UserGroupMap by mappingid
     * DELETE method for USER_GROUP_MAP_MASTER table with param mappingid
     */
    @Override
    public void destroyUserGroupMapping(Long mappingId) {

	userGroupMapDao.deleteUserGroupMap(mappingId);
    }

    @Override
    public List<UserGroupMapDTO> getFieldEq(Class<UserGroupMapDTO> type, String propertyName, Object value, int offset,
	    int size) {
	return null;
    }

}
