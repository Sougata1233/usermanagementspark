package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.SubMenuDTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenu1DTO;
import com.easybusiness.usermanagement.DTO.UserGroupMenuSubMenuDTO;
import com.easybusiness.usermanagement.entity.UserGroupMenuSubMenu;

public interface UserGroupMenuSubMenuMappingService {

    public ResponseEntity<UserGroupMenuSubMenuDTO> getUserGroupMenuBymappingId(Long mappingId);

    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupId(Long groupId);

    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByMenuId(Long menuId);

    public ResponseEntity<UserGroupMenuSubMenuDTO> persistUserGroupMenu(UserGroupMenuSubMenuDTO UserGroupMenuDTO);

    public void destroyUserGroupMenu(Long userGroupMenuId);

    public List<UserGroupMenuSubMenuDTO> getFieldEq(final Class<UserGroupMenuSubMenuDTO> type,
	    final String propertyName, final Object value, int offset, int size);

    public List<UserGroupMenuSubMenuDTO> getUserGroupMenuByGroupName(String groupName);

    public List<SubMenuDTO> getAllSubMenusAndMenusByGroupId(Long groupId);

    public List<SubMenuDTO> getAllSubMenusAndMenusByGroupName(String groupName);
    
    public List<UserGroupMenuSubMenu1DTO> getUserGroupMenuSubMenuByUser(Long userId);
    
    public void updateUserGroupMenuSubMenuByUser(List<UserGroupMenuSubMenu> userGroupMenuSubMenu);
//    public void updateUserGroupMenuSubMenuByUser(UserGroupMenuSubMenu[] userGroupMenuSubMenu);


}
