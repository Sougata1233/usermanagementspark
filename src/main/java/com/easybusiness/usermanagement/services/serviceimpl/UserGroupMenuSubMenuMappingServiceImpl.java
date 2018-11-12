package com.easybusiness.usermanagement.services.serviceimpl;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.DTO.MenuDTO;
import com.easybusiness.usermanagement.DTO.MenuSubMenuDTO;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserGroupDTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenu1DTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenuDTO;
import com.easybusiness.usermanagement.dao.MenuDao;
import com.easybusiness.usermanagement.dao.SubMenuDao;
import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.dao.UserGroupDao;
import com.easybusiness.usermanagement.dao.UserGroupMapDao;
import com.easybusiness.usermanagement.dao.UserGroupMenuSubMenuDao;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMap;
import com.easybusiness.usermanagement.entity.UserGroupMenuSubMenu;
import com.easybusiness.usermanagement.services.UserGroupMenuSubMenuMappingService;

/*
 * Service and RestController class for usergroupmenusubmenu
 */
@RestController
@RequestMapping("/easybusiness/usergroupmenusubmenu/")
public class UserGroupMenuSubMenuMappingServiceImpl implements UserGroupMenuSubMenuMappingService {

    @Autowired
    UserGroupMenuSubMenuDao userGroupMenuSubMenuDao;

    @Autowired
    UserGroupDao userGroupDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    SubMenuDao subMenuDao;
    
    @Autowired
    UserGroupMapDao userGroupMapDao;
    
    @Autowired
    UserDao userDao;
    
    @Autowired 
    UserGroupMapDao usergroupmapDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getUserGroupMenuBymappingId(java.lang.Long)
     * fetching user group menu by mapping id
     * GET method with param mappingid for USER_GRP_MENU_MASTER table
     */
    @Override
    public ResponseEntity<UserGroupMenuSubMenuDTO> getUserGroupMenuBymappingId(Long mappingId) {

	UserGroupMenuSubMenu userGroupMenuEntity = userGroupMenuSubMenuDao.findUserGroupMenuById(mappingId).get();
	UserGroupMenuSubMenuDTO userGroupMenuDto = prepareUserGroupMenuDTO(userGroupMenuEntity);
	return new ResponseEntity<UserGroupMenuSubMenuDTO>(userGroupMenuDto, HttpStatus.FOUND);

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getUserGroupMenuByGroupId(java.lang.Long)
     * fetching user group menu by groupid
     * GET method for for USER_GRP_MENU_MASTER table with param groupid
     */
    @Override
    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupId(Long groupId) {

	UserGroup userGroupEntity = userGroupDao.findUserGroupById(groupId).get();
	List<UserGroupMenuSubMenu> userGroupMenuEntityList = userGroupMenuSubMenuDao
		.findUserGroupMenuByUserGroup(userGroupEntity);
	List<UserGroupMenuSubMenuDTO> userGroupMenuList = new ArrayList<UserGroupMenuSubMenuDTO>();
	userGroupMenuEntityList.forEach(userGroupMenuEntity -> {
	    System.out.println("group menu sub menu entity is " + userGroupMenuEntity.toString());
	    UserGroupMenuSubMenuDTO userGroupMenuDTO = new UserGroupMenuSubMenuDTO();
	    userGroupMenuDTO = prepareUserGroupMenuDTO(userGroupMenuEntity);
	    userGroupMenuList.add(userGroupMenuDTO);

	});
	return userGroupMenuList;
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getAllSubMenusAndMenusByGroupId(java.lang.Long)
     * fetching all menu and sub menu by group id
     * GET method for USER_GRP_MENU_MASTER table with param groupid
     */
    @Override
    public List<SubMenuDTO> getAllSubMenusAndMenusByGroupId(Long groupId) {

	UserGroup userGroupEntity = userGroupDao.findUserGroupById(groupId).get();
	List<UserGroupMenuSubMenu> userGroupMenuEntityList = userGroupMenuSubMenuDao
		.findUserGroupMenuByUserGroup(userGroupEntity);
	List<SubMenuDTO> userGroupMenuList = new ArrayList<SubMenuDTO>();
	userGroupMenuEntityList.forEach(userGroupMenuEntity -> {
	    System.out.println("group menu sub menu entity is " + userGroupMenuEntity.toString());
	    UserGroupMenuSubMenuDTO userGroupMenuDTO = new UserGroupMenuSubMenuDTO();
	    userGroupMenuDTO = prepareUserGroupMenuDTO(userGroupMenuEntity);
	    userGroupMenuList.add(userGroupMenuDTO.getSubMenuItem());

	});
	return userGroupMenuList;
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getAllSubMenusAndMenusByGroupName(java.lang.String)
     * fetching menus and submenus by groupname
     * GET method for USER_GRP_MENU_MASTER table with param groupname
     */
    @Override
    public List<SubMenuDTO> getAllSubMenusAndMenusByGroupName(String groupName) {

	UserGroup userGroupEntity = userGroupDao.findByUserGroupName(groupName);
	List<UserGroupMenuSubMenu> userGroupMenuEntityList = userGroupMenuSubMenuDao
		.findUserGroupMenuByUserGroup(userGroupEntity);
	List<SubMenuDTO> userGroupMenuList = new ArrayList<SubMenuDTO>();
	userGroupMenuEntityList.forEach(userGroupMenuEntity -> {
	    System.out.println("group menu sub menu entity is " + userGroupMenuEntity.toString());
	    UserGroupMenuSubMenuDTO userGroupMenuDTO = new UserGroupMenuSubMenuDTO();
	    userGroupMenuDTO = prepareUserGroupMenuDTO(userGroupMenuEntity);
	    userGroupMenuList.add(userGroupMenuDTO.getSubMenuItem());

	});
	return userGroupMenuList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getUserGroupMenuByGroupName(java.lang.String)
     * fetching menu by groupname
     * GET method for USER_GRP_MENU_MASTER table with param groupName
     */
    @Override
    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupName(String groupName) {

	UserGroup userGroupEntity = userGroupDao.findByUserGroupName(groupName);
	List<UserGroupMenuSubMenu> userGroupMenuEntityList = userGroupMenuSubMenuDao
		.findUserGroupMenuByUserGroup(userGroupEntity);
	List<UserGroupMenuSubMenuDTO> userGroupMenuList = new ArrayList<UserGroupMenuSubMenuDTO>();
	userGroupMenuEntityList.forEach(userGroupMenuEntity -> {
	    System.out.println("group menu sub menu entity is " + userGroupMenuEntity.toString());
	    UserGroupMenuSubMenuDTO userGroupMenuDTO = new UserGroupMenuSubMenuDTO();
	    userGroupMenuDTO = prepareUserGroupMenuDTO(userGroupMenuEntity);
	    userGroupMenuList.add(userGroupMenuDTO);

	});
	return userGroupMenuList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getUserGroupMenuByMenuId(java.lang.Long)
     * fetching user group menu by menu id
     * GET method for USER_GRP_MENU_MASTER table with param menuid
     */
    @Override
    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByMenuId(Long menuId) {

	Menu menuEntity = menuDao.findMenuById(menuId).get();
	List<UserGroupMenuSubMenu> userGroupMenuEntityList = userGroupMenuSubMenuDao
		.findUserGroupMenuByMenu(menuEntity);
	List<UserGroupMenuSubMenuDTO> userGroupMenuList = new ArrayList<UserGroupMenuSubMenuDTO>();
	userGroupMenuEntityList.forEach(userGroupMenuEntity -> {
	    UserGroupMenuSubMenuDTO userGroupMenuDTO = new UserGroupMenuSubMenuDTO();
	    userGroupMenuDTO = prepareUserGroupMenuDTO(userGroupMenuEntity);
	    userGroupMenuList.add(userGroupMenuDTO);

	});
	return userGroupMenuList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#persistUserGroupMenu(com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenuDTO)
     * mapping user group to menu and sub menu
     * POST method for USER_GRP_MENU_MASTER table with request body UserGroupMenuSubMenuDTO
     */
    @Override
    public ResponseEntity<UserGroupMenuSubMenuDTO> persistUserGroupMenu(
    		UserGroupMenuSubMenuDTO userGroupMenuSubMenuDTO) {

	UserGroupMenuSubMenu userGroupMenuSubMenu = new UserGroupMenuSubMenu();
	userGroupMenuSubMenu.setFromDate(userGroupMenuSubMenuDTO.getFromDate());
	userGroupMenuSubMenu.setIsEnable(userGroupMenuSubMenuDTO.getIsEnable());
	
	Menu menu = menuDao.findMenuById(userGroupMenuSubMenuDTO.getMenuItem().getId()).get();
	userGroupMenuSubMenu.setMenuItem(menu);
	userGroupMenuSubMenu.setModifiedBy(userGroupMenuSubMenuDTO.getModifiedBy());
	userGroupMenuSubMenu.setModifiedOn(userGroupMenuSubMenuDTO.getModifiedOn());
	userGroupMenuSubMenu.setToDate(userGroupMenuSubMenuDTO.getToDate());
	
	UserGroup userGroup = userGroupDao.findUserGroupById(userGroupMenuSubMenuDTO.getUserGroup().getId()).get();
	userGroupMenuSubMenu.setUserGroup(userGroup);

	SubMenu subMenu = subMenuDao.findSubMenuById(userGroupMenuSubMenuDTO.getSubMenuItem().getId()).get();
	userGroupMenuSubMenu.setSubMenuItem(subMenu);

	UserGroupMenuSubMenu menusubmenu = userGroupMenuSubMenuDao.addUserGroupMenu(userGroupMenuSubMenu);
	userGroupMenuSubMenuDTO.setId(menusubmenu.getId());
	return new ResponseEntity<UserGroupMenuSubMenuDTO>(userGroupMenuSubMenuDTO, HttpStatus.CREATED);

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#destroyUserGroupMenu(java.lang.Long)
     * deleting usergroup menu by mapping id
     * PUT method for USER_GRP_MENU_MASTER table with param mapping id
     * this method does not delete usergroup menu sub menu mapping rather it disables it by toggling isEnable field to 0
     */
    @Override
    public void destroyUserGroupMenu(Long mappingId) {

	userGroupMenuSubMenuDao.deleteUserGroupMenu(mappingId);
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#getUserGroupMenuSubMenuByUser(java.lang.Long)
     * fetching usergroup menu submenu mapping by userid
     * GET method for USER_GRP_MENU_MASTER table with param userid
     */
    @Override
    public List<UserGroupMenuSubMenu1DTO> getUserGroupMenuSubMenuByUser(Long userid) {
		User user = userDao.findUserById(userid);
		List<UserGroupMap> userGroup = userGroupMapDao.findByUser(user);
		List<UserGroupMenuSubMenu> userGroupMenuSubmenu = 
				userGroupMenuSubMenuDao.findUserGroupMenuByUserGroup(userGroup.get(0).getUserGroup());
		System.out.println(userGroupMenuSubmenu);
		
		List<UserGroupMenuSubMenu1DTO> readOnlyList = new ArrayList<>();
		
		
		userGroupMenuSubmenu.forEach(groupmenusubmenu->{
			UserGroupMenuSubMenu1DTO groupmenu = new UserGroupMenuSubMenu1DTO();
			long readonly = groupmenusubmenu.getReadonly();
			
			groupmenu.setUserId(prepareUserDTO(user));
			
			//for nested lsit of submenus of respective menus
			groupmenu.setMenu(prepareMenuSubMenuResponse(groupmenusubmenu.getMenuItem()));
			
//			groupmenu.setSubmenu(prepareSubMenuResponse(groupmenusubmenu.getSubMenuItem()));
			groupmenu.setMappingId(groupmenusubmenu.getId());
			groupmenu.setReadOnly(readonly);
			
			readOnlyList.add(groupmenu);
		});
		
    	
    	return readOnlyList;
	}
    
    
    /*
     * preparing a DTO for nested lsit of submenus of respective menus
     */
    private MenuSubMenuDTO prepareMenuSubMenuResponse(Menu menuItem) {
		List<SubMenu> subMenuList = subMenuDao.findByMenu(menuItem);
		MenuSubMenuDTO menusubmenu = new MenuSubMenuDTO();
		menusubmenu.setMenuDetails(menuItem.getMenuName());
		menusubmenu.setSubMenu(subMenuList);
		return menusubmenu;
	}


	/*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usergrouptomenusubmenu.UserGroupMenuSubMenuMappingService#updateUserGroupMenuSubMenuByUser(java.util.List)
     * updating usergroup menu submenu mapping  by user
     * this method makes a menu or submenu readonly or read-write for a user by setting readOnly field 0 or 1
     * 1 for read-write and 0 for readonly
     */
    @Override
    public void updateUserGroupMenuSubMenuByUser(List<UserGroupMenuSubMenu> userGroupMenuSubMenu) {
    	
    	/*User user = userDao.findUserById(userId);
		List<UserGroupMap> userGroup = userGroupMapDao.findByUser(user);
		List<UserGroupMenuSubMenu> userGroupMenuSubmenu = 
				userGroupMenuSubMenuDao.findUserGroupMenuByUserGroup(userGroup.get(0).getUserGroup());*/
		
    	System.out.println(userGroupMenuSubMenu);
    	
    	userGroupMenuSubMenu.forEach(usergroupmenusubmenu->{
    		UserGroupMenuSubMenu userGroupMenuSubMenuList = 
        			userGroupMenuSubMenuDao.findUserGroupMenuByMappingId(usergroupmenusubmenu.getId());
    		
    		userGroupMenuSubMenuList.setFromDate(userGroupMenuSubMenuList.getFromDate());
    		userGroupMenuSubMenuList.setIsEnable(userGroupMenuSubMenuList.getIsEnable());
    		userGroupMenuSubMenuList.setMenuItem(userGroupMenuSubMenuList.getMenuItem());
    		userGroupMenuSubMenuList.setModifiedBy(userGroupMenuSubMenuList.getModifiedBy());
    		userGroupMenuSubMenuList.setModifiedOn(userGroupMenuSubMenuList.getModifiedOn());
    		userGroupMenuSubMenuList.setSubMenuItem(userGroupMenuSubMenuList.getSubMenuItem());
    		userGroupMenuSubMenuList.setToDate(userGroupMenuSubMenuList.getToDate());
    		userGroupMenuSubMenuList.setUserGroup(userGroupMenuSubMenuList.getUserGroup());
    		
    		userGroupMenuSubMenuList.setReadonly(usergroupmenusubmenu.getReadonly());
    		
    		userGroupMenuSubMenuDao.updateUserGroupMenu(userGroupMenuSubMenuList);
    		
    	});
		
    	
	}

    @Override
    public List<UserGroupMenuSubMenuDTO> getFieldEq(Class<UserGroupMenuSubMenuDTO> type, String propertyName,
	    Object value, int offset, int size) {
	return null;
    }

    
    /*
     * preparing UserGroupMenuSubMenuDTO from UserGroupMenuSubMenu entity
     */
    private UserGroupMenuSubMenuDTO prepareUserGroupMenuDTO(UserGroupMenuSubMenu userGroupMenuEntity) {

	UserGroupMenuSubMenuDTO userGroupMenuDto = new UserGroupMenuSubMenuDTO();
	
	userGroupMenuDto.setFromDate(userGroupMenuEntity.getFromDate());
	userGroupMenuDto.setId(userGroupMenuEntity.getId());
	userGroupMenuDto.setIsEnable(userGroupMenuEntity.getIsEnable());
	
	MenuDTO menuDto = prepareMenuDTO(userGroupMenuEntity);
	userGroupMenuDto.setMenuItem(menuDto);
	
	UserGroupDTO userGroupDTO = new UserGroupDTO();
	
	userGroupMenuDto.setModifiedBy(userGroupMenuEntity.getModifiedBy());
	userGroupMenuDto.setModifiedOn(userGroupMenuEntity.getModifiedOn());
	userGroupMenuDto.setToDate(userGroupMenuEntity.getToDate());
	userGroupMenuDto.setUserGroup(prepareUserGroupDTO(userGroupMenuEntity.getUserGroup()));

	SubMenuDTO subMenuItem = new SubMenuDTO();
	subMenuItem.setId(userGroupMenuEntity.getSubMenuItem().getId());
	//subMenuItem.setMenu(userGroupMenuEntity.getSubMenuItem().getMenu());
	subMenuItem.setModifiedBy(userGroupMenuEntity.getSubMenuItem().getModifiedBy());
	subMenuItem.setModifiedTime(userGroupMenuEntity.getSubMenuItem().getModifiedTime());
	subMenuItem.setSubMenu(userGroupMenuEntity.getSubMenuItem().getSubMenu());
	subMenuItem.setMenu(menuDto);
	userGroupMenuDto.setSubMenuItem(subMenuItem);
	
	return userGroupMenuDto;
    }

    private MenuDTO prepareMenuDTO(UserGroupMenuSubMenu userGroupMenuEntity) {
	MenuDTO menuDto = new MenuDTO();
	menuDto.setId(userGroupMenuEntity.getMenuItem().getId());
	menuDto.setMenuName(userGroupMenuEntity.getMenuItem().getMenuName());
	menuDto.setModifiedBy(userGroupMenuEntity.getMenuItem().getModifiedBy());
	menuDto.setModifiedTime(userGroupMenuEntity.getMenuItem().getModifiedTime());
	menuDto.setMenuIconName(userGroupMenuEntity.getMenuItem().getMenuIconName());
	return menuDto;
    }

    
    /*
     * preparing UserGroupDTO from UserGroup entity
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
     * preparing SubMenuDTO from SubMenu entity
     */
    private SubMenuDTO prepareSubMenuResponse(SubMenu subMenu) {

    	SubMenuDTO subMenuDTO = new SubMenuDTO();
    	subMenuDTO.setId(subMenu.getId());
    	subMenuDTO.setMenu(prepareMenuResponse(subMenu.getMenu()));
    	subMenuDTO.setModifiedBy(subMenu.getModifiedBy());
    	subMenuDTO.setModifiedTime(subMenu.getModifiedTime());
    	subMenuDTO.setSubMenu(subMenu.getSubMenu());
    	return subMenuDTO;
        }
    
    /*
     * preparing MenuDTO from Menu entity
     */
    private MenuDTO prepareMenuResponse(Menu menu) {
    	MenuDTO menuItem = new MenuDTO();
    	menuItem.setId(menu.getId());
    	menuItem.setMenuName(menu.getMenuName());
    	menuItem.setModifiedBy(menu.getModifiedBy());
    	menuItem.setModifiedTime(menu.getModifiedTime());
    	menuItem.setMenuIconName(menu.getMenuIconName());
    	return menuItem;
        }
    
    
    /*
     * preparing UserDTO from User entity
     */
    private UserDTO prepareUserDTO(User userEntity) {
    	UserDTO userDTO = new UserDTO();	//creating blank user DTO object
    	
    	userDTO.setAlternateEmail(userEntity.getAlternateEmail());
    	userDTO.setDateOfBirth(userEntity.getDateOfBirth());
    	
    	//getting department object
    	DepartmentDto deptDO = new DepartmentDto();
    	try {
    	    deptDO.setDeptName(userEntity.getDepartment().getDeptName());
    	    deptDO.setId(userEntity.getDepartment().getId());

    	    //getting organization object
    	    OrganizationDto orgDTO = new OrganizationDto();

    	    orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
    	    orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
    	    orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
    	    deptDO.setOrganization(orgDTO);
    	    
    	    userDTO.setDepartment(deptDO); //setting department DTO
    	    userDTO.setOrganization(orgDTO); //setting organization DTO
    	} catch (Exception e) {
    		e.printStackTrace();
//    	    LOGGER.error("error in getting organization/department of user {} {}", userEntity.getUserName(),
    		    
    	}
    	
    	//getting designation DTO
    	try {
    	    DesignationDto desigDTO = new DesignationDto();

    	    desigDTO.setDesig(userEntity.getDesignation().getDesig());
    	    desigDTO.setId(userEntity.getDesignation().getId());
    	    desigDTO.setModBy(userEntity.getDesignation().getModBy());
    	    desigDTO.setModOn(userEntity.getDesignation().getModOn());

    	    userDTO.setDesignation(desigDTO);
    	} catch (Exception e) {
    		e.printStackTrace();
//    	    LOGGER.error("error in getting designation of user {} {}", userEntity.getUserName(), e.getMessage());
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
    	userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
    	
    	//getting user image
    	int usrImgLength;
    	try {
    		if(userEntity.getUserImg() != null) {
    		usrImgLength = (int) userEntity.getUserImg().length();
    		System.out.println(usrImgLength);
    		if(0 != usrImgLength) {
    			userDTO.setUserImg(userEntity.getUserImg().getBytes(1, usrImgLength));
    		}else {
    			userDTO.setUserImg(null);
    		}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

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
    
	  //preparing location master DTO for fetching location
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
