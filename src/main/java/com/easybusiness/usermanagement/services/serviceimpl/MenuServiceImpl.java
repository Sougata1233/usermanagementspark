package com.easybusiness.usermanagement.services.serviceimpl;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easybusiness.usermanagement.DTO.MenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuUrlDTO;
import com.easybusiness.usermanagement.dao.MenuDao;
import com.easybusiness.usermanagement.dao.SubMenuDao;
import com.easybusiness.usermanagement.dao.SubMenuUrlDao;
import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.SubMenuUrl;
import com.easybusiness.usermanagement.services.MenuService;


/*
 * Service and RestController class for MENU_MASTER table
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Autowired
    SubMenuDao subMenuDao;

    @Autowired
    SubMenuUrlDao subMenuUrlDao;

    private static Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getMenuByName(java.lang.String)
     * fetching menu by menuname
     * GET method for MENU_MASTER table with param menuName
     */
    @Override
    public MenuDTO getMenuByName(String menuName) {

	Menu menu = menuDao.findByMenuName(menuName);
	return prepareMenuResponse(menu);
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

    @Override
    public List<MenuDTO> getMenuAsPerCriteria(String whereClause) {
	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#addMenu(com.easybusiness.usermanagement.DTO.MenuDTO)
     * saving menu to database
     * POST method for MENU_MASTER table with MenuDTO request body
     */
    @Override
    public ResponseEntity<MenuDTO> addMenu(MenuDTO menuDTO) {
	Menu menuItem = new Menu();
	menuItem.setMenuName(menuDTO.getMenuName());
	menuItem.setModifiedBy(menuDTO.getModifiedBy());
	menuItem.setModifiedTime(menuDTO.getModifiedTime());
	menuItem.setMenuIconName(menuDTO.getMenuIconName());
	if(menuDTO.getId() == 0) {
		menuDao.addMenu(menuItem);
	}else {
		Menu menu = menuDao.findMenuById(menuDTO.getId()).get();
		menu.setMenuIconName(menuDTO.getMenuIconName());
		menu.setMenuName(menuDTO.getMenuName());
		menu.setModifiedBy(menuDTO.getModifiedBy());
		menu.setModifiedTime(Date.valueOf(LocalDate.now()));
		menuDao.updateMenu(menu);
	}
	
	return new ResponseEntity<MenuDTO>(menuDTO, HttpStatus.CREATED);

    }
    
    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#updateMenu(com.easybusiness.usermanagement.DTO.MenuDTO)
     * updating menu
     * POST method for MENU_MASTER table with MenuDTO request body
     */
    @Override
	public void updateMenu(MenuDTO menu) {
		Menu menuEntity = menuDao.findMenuById(menu.getId()).get();
		
		menuEntity.setMenuIconName(menu.getMenuIconName());
		menuEntity.setMenuName(menu.getMenuName());
		menuEntity.setModifiedBy(menu.getModifiedBy());
		menuEntity.setModifiedTime(menu.getModifiedTime());
		
		menuDao.updateMenu(menuEntity);
		LOGGER.info("menu successfully updated "+menu.toString());
		
	}

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getAllMenuItems()
     * Fetching all menus
     * GET method for MENU_MASTER table
     */
    @Override
    public List<MenuDTO> getAllMenuItems() throws Exception {
	List<Menu> menuList = menuDao.findAll();
	List<MenuDTO> menuModelList = new ArrayList<MenuDTO>();
	menuList.forEach(menu -> {

	    MenuDTO menuItem = prepareMenuResponse(menu);
	    menuModelList.add(menuItem);

	});
	return menuModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getMenuById(java.lang.Long)
     * fetching menu by menuId
     * GET method for MENU_MASTER table with param menuId
     */
    @Override
    public MenuDTO getMenuById(Long menuId) {
	LOGGER.info("inside get Menu By Id");
	Menu menu = menuDao.findMenuById(menuId).get();
	MenuDTO menuItem = prepareMenuResponse(menu);

	return menuItem;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#deleteMenu(java.lang.Long)
     * deleting menu by menuId
     * DELETE method for MENU_MASTER table with param menuID
     */
    @Override
    public ResponseEntity<MenuDTO> deleteMenu(Long menuId) {
	Menu menu = menuDao.findMenuById(menuId).get();
	menuDao.deleteMenu(menuId);
	return new ResponseEntity<MenuDTO>(prepareMenuResponse(menu), HttpStatus.OK);
    }

    @Override
    public List<MenuDTO> getFieldEq(Class<MenuDTO> type, String propertyName, Object value, int offset, int size) {
	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getSubMenuById(java.lang.Long)
     * fetching submenu by parent menu id
     * GET method for SUBMENU_MASTER table with param menuId
     */
    @Override
    public List<SubMenuDTO> getSubMenuById(Long parentMenuId) {
	List<SubMenu> subMenuList = subMenuDao.findByMenu(menuDao.findMenuById(parentMenuId).get());
	List<SubMenuDTO> subMenuDTOList = new ArrayList<SubMenuDTO>();
	subMenuList.forEach(subMenu -> {
	    SubMenuDTO subMenuDTO = new SubMenuDTO();
	    subMenuDTO.setId(subMenu.getId());
	    subMenuDTO.setSubMenu(subMenu.getSubMenu());
	    MenuDTO menuDTOvalue = new MenuDTO();
	    menuDTOvalue.setId(subMenu.getMenu().getId());
	    menuDTOvalue.setMenuName(subMenu.getMenu().getMenuName());
	    menuDTOvalue.setModifiedBy(subMenu.getMenu().getModifiedBy());
	    menuDTOvalue.setModifiedTime(subMenu.getMenu().getModifiedTime());
	    menuDTOvalue.setMenuIconName(subMenu.getMenu().getMenuIconName());
	    subMenuDTO.setMenu(menuDTOvalue);
	    subMenuDTOList.add(subMenuDTO);
	});
	return subMenuDTOList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getSubMenuBySubMenuId(java.lang.Long)
     * fetching submenu by submenuid
     * GET method for SUBMENU_MASTER table with param menuId(submenuId)
     */
    @Override
    public SubMenuDTO getSubMenuBySubMenuId(Long subMenuId) {
	SubMenu subMenu = subMenuDao.findSubMenuById(subMenuId).get();

	SubMenuDTO subMenuDTO = new SubMenuDTO();
	subMenuDTO.setId(subMenu.getId());
	subMenuDTO.setSubMenu(subMenu.getSubMenu());
	MenuDTO menuDTOvalue = new MenuDTO();
	menuDTOvalue.setId(subMenu.getMenu().getId());
	menuDTOvalue.setMenuName(subMenu.getMenu().getMenuName());
	menuDTOvalue.setModifiedBy(subMenu.getMenu().getModifiedBy());
	menuDTOvalue.setModifiedTime(subMenu.getMenu().getModifiedTime());
	menuDTOvalue.setMenuIconName(subMenu.getMenu().getMenuIconName());
	subMenuDTO.setMenu(menuDTOvalue);

	return subMenuDTO;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getAllSubMenuItems()
     * fetching all submenus
     * GET method for SUBMENU_MASTER table 
     */
    @Override
    public List<SubMenuDTO> getAllSubMenuItems() throws Exception {
	List<SubMenu> subMenuList = subMenuDao.findAll();
	List<SubMenuDTO> subMenuModelList = new ArrayList<SubMenuDTO>();
	subMenuList.forEach(subMenu -> {

	    SubMenuDTO subMenuItem = prepareSubMenuResponse(subMenu);
	    subMenuModelList.add(subMenuItem);

	});
	return subMenuModelList;
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
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#addSubMenu(com.easybusiness.usermanagement.DTO.SubMenuDTO)
     * saving submenu to database
     * POST method for SUBMENU_MASTER table with SubMenuDTO request body
     */
    @Override
    public ResponseEntity<SubMenuDTO> addSubMenu(SubMenuDTO subMenuDTO) {
	SubMenu subMenu = new SubMenu();
	Menu menuItem = new Menu();
	menuItem.setMenuName(subMenuDTO.getMenu().getMenuName());
	menuItem.setModifiedBy(subMenuDTO.getMenu().getModifiedBy());
	menuItem.setModifiedTime(subMenuDTO.getMenu().getModifiedTime());
	menuItem.setId(subMenuDTO.getMenu().getId());
	menuItem.setMenuIconName(subMenuDTO.getMenu().getMenuIconName());
	subMenu.setMenu(menuItem);
	subMenu.setModifiedBy(subMenuDTO.getModifiedBy());
	subMenu.setModifiedTime(subMenuDTO.getModifiedTime());
	subMenu.setSubMenu(subMenuDTO.getSubMenu());
	subMenuDao.addSubMenu(subMenu);
	return new ResponseEntity<SubMenuDTO>(subMenuDTO, HttpStatus.CREATED);
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#updateSubMenu(com.easybusiness.usermanagement.DTO.SubMenuDTO)
     * updating submenu
     * POST method for SUBMENU_MASTER table with SubMenuDTO request body
     */
    @Override
    public void updateSubMenu(SubMenuDTO subMenuDto) {
		SubMenu submenu = subMenuDao.findSubMenuById(subMenuDto.getId()).get();
		Menu menuItem = menuDao.findMenuById(subMenuDto.getMenu().getId()).get();
		
		menuItem.setMenuName(subMenuDto.getMenu().getMenuName());
		menuItem.setModifiedBy(subMenuDto.getMenu().getModifiedBy());
		menuItem.setModifiedTime(subMenuDto.getMenu().getModifiedTime());
		menuItem.setId(subMenuDto.getMenu().getId());
		
		submenu.setMenu(menuItem);
		submenu.setModifiedBy(subMenuDto.getModifiedBy());
		submenu.setModifiedTime(subMenuDto.getModifiedTime());
		submenu.setSubMenu(subMenuDto.getSubMenu());

		
		subMenuDao.updateSubMenu(submenu);
		
	}

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#deleteSubMenu(java.lang.Long)
     * deleting submenu by submenuid
     * DELETE method for SUBMENU_MASTER table with param submenuId
     */
    @Override
    public ResponseEntity<SubMenuDTO> deleteSubMenu(Long subMenuId) {
	SubMenu subMenu = subMenuDao.findSubMenuById(subMenuId).get();
	SubMenuDTO subMenuDTO = new SubMenuDTO();
	subMenuDTO.setId(subMenu.getId());
	subMenuDTO.setSubMenu(subMenu.getSubMenu());

	subMenuDao.deleteSubMenu(subMenuId);
	return new ResponseEntity<SubMenuDTO>(subMenuDTO, HttpStatus.OK);
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.menu.MenuService#getUrlBySubMenuId(java.lang.Long)
     * fetching menu url by subMenuId
     * GET method for SUBMENU_URL_MAP table with param subMenuId
     */
    @Override
    public SubMenuUrlDTO getUrlBySubMenuId(Long subMenuId) {
	SubMenuUrl subMenuUrlEntity = subMenuUrlDao.findBySubMenu(subMenuDao.findSubMenuById(subMenuId).get());
	SubMenuUrlDTO subMenuUrlDTO = new SubMenuUrlDTO();
	subMenuUrlDTO.setCreatedBy(subMenuUrlEntity.getCreatedBy());
	subMenuUrlDTO.setCreatedOn(subMenuUrlEntity.getCreatedOn());
	subMenuUrlDTO.setId(subMenuUrlEntity.getId());
	SubMenuDTO subMenuDTO = new SubMenuDTO();
	subMenuDTO.setId(subMenuUrlEntity.getSubMenu().getId());
	subMenuDTO.setSubMenu(subMenuUrlEntity.getSubMenu().getSubMenu());
	subMenuUrlDTO.setSubMenu(subMenuDTO);
	subMenuUrlDTO.setUrl(subMenuUrlEntity.getUrl());
	return subMenuUrlDTO;
    }

}
