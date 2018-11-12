package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.MenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuUrlDTO;


public interface MenuService {

    public MenuDTO getMenuByName(String menuName);

    public List<MenuDTO> getMenuAsPerCriteria(String whereClause);

    public ResponseEntity<MenuDTO> addMenu(MenuDTO menu);

    public List<MenuDTO> getAllMenuItems() throws Exception;

    public MenuDTO getMenuById(Long menuId);

    public ResponseEntity<MenuDTO> deleteMenu(Long menuId);

    public List<MenuDTO> getFieldEq(final Class<MenuDTO> type, final String propertyName, final Object value, int offset,
	    int size);
    
    public List<SubMenuDTO> getSubMenuById(Long subMenuId);
    
    public ResponseEntity<SubMenuDTO> addSubMenu(SubMenuDTO subMenu);
    
    public ResponseEntity<SubMenuDTO> deleteSubMenu(Long subMenuId);
    
    public SubMenuUrlDTO getUrlBySubMenuId(Long subMenuId);

    SubMenuDTO getSubMenuBySubMenuId(Long subMenuId);

    List<SubMenuDTO> getAllSubMenuItems() throws Exception;
    
    public void updateMenu(MenuDTO menuDto);
    
    public void updateSubMenu(SubMenuDTO subMenu);


}
