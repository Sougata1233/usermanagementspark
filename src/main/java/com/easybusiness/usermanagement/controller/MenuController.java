package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.MenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.SubMenuUrlDTO;
import com.easybusiness.usermanagement.services.serviceimpl.MenuServiceImpl;

/*
 * Service and RestController class for MENU_MASTER table
 */
@RestController
@RequestMapping("easybusiness/menu/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class MenuController {
	
	@Autowired
	MenuServiceImpl menuService;
	
	@GetMapping("getMenuByName/{menuName}")
	public MenuDTO getMenuByName(@PathVariable("menuName") String menuName) {
		return menuService.getMenuByName(menuName);
	}
	
	@PostMapping("addMenu")
	public ResponseEntity<MenuDTO> addMenu(@RequestBody MenuDTO menuDTO){
		return menuService.addMenu(menuDTO);
	}
	
	@PostMapping("updateMenu")
	public void updateMenu(@RequestBody MenuDTO menu) {
		menuService.updateMenu(menu);
	}
	
	@GetMapping("getAllMenu")
	public List<MenuDTO> getAllMenuItems() throws Exception {
		return menuService.getAllMenuItems();
	}
	
	@GetMapping("getMenuById/{menuId}")
	public MenuDTO getMenuById(@PathVariable("menuId") Long menuId) {
		return menuService.getMenuById(menuId);
	}
	
	@DeleteMapping("deleteMenu/{menuId}")
	public ResponseEntity<MenuDTO> deleteMenu(@PathVariable("menuId") Long menuId) {
		return menuService.deleteMenu(menuId);
	}
	
	@GetMapping("getSubMenuByParentMenuId/{menuId}")
    public List<SubMenuDTO> getSubMenuById(@PathVariable("menuId") Long parentMenuId) {
		return menuService.getSubMenuById(parentMenuId);
	}
	
	@GetMapping("getSubMenuBySubMenuId/{menuId}")
	public SubMenuDTO getSubMenuBySubMenuId(@PathVariable("menuId") Long subMenuId) {
		return menuService.getSubMenuBySubMenuId(subMenuId);
	}
	
	@GetMapping("getAllSubMenu")
	public List<SubMenuDTO> getAllSubMenuItems() throws Exception {
		return menuService.getAllSubMenuItems();
	}
	
	@PostMapping("addSubMenu")
	public ResponseEntity<SubMenuDTO> addSubMenu(@RequestBody SubMenuDTO subMenuDTO){
		return menuService.addSubMenu(subMenuDTO);
	}
	
	@PostMapping("updateSubMenu")
	public void updateSubMenu(@RequestBody SubMenuDTO subMenuDto) {
		menuService.updateSubMenu(subMenuDto);
	}
	
	@DeleteMapping("deleteSubMenu/{submenuId}")
	public ResponseEntity<SubMenuDTO> deleteSubMenu(@PathVariable("submenuId") Long subMenuId){
		return menuService.deleteSubMenu(subMenuId);
	}
	
	@GetMapping("getUrlBySubMenuId/{subMenuId}")
	public SubMenuUrlDTO getUrlBySubMenuId(@PathVariable("subMenuId") Long subMenuId) {
		return menuService.getUrlBySubMenuId(subMenuId);
	}
	

}
