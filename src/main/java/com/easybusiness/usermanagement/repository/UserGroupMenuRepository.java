package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMenu;

public interface UserGroupMenuRepository extends JpaRepository<UserGroupMenu, Long>{

    Optional<UserGroupMenu> findById(Long i);

    List<UserGroupMenu> findByUserGroup(UserGroup userGroup);

    List<UserGroupMenu> findByMenuItem(Menu menu);
    
    List<UserGroupMenu> findByUserGroupAndMenuItem(UserGroup userGroup,Menu menu);

}
