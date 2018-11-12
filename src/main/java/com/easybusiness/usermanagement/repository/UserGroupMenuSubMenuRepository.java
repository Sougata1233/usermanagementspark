package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMenuSubMenu;

public interface UserGroupMenuSubMenuRepository	extends JpaRepository<UserGroupMenuSubMenu, Long> {

    Optional<UserGroupMenuSubMenu> findById(Long i);
    
    @Query("select m from UserGroupMenuSubMenu m where m.id = :id ")
    UserGroupMenuSubMenu findByMappingId(@Param("id") Long id);

    List<UserGroupMenuSubMenu> findByUserGroup(UserGroup userGroup);

    List<UserGroupMenuSubMenu> findByMenuItem(Menu menu);
    
    List<UserGroupMenuSubMenu> findBySubMenuItem(SubMenu subMenu);
    
    List<UserGroupMenuSubMenu> findByUserGroupAndSubMenuItem(UserGroup userGroup,SubMenu subMenu);

}
