package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.UserGroupMap;
import com.easybusiness.usermanagement.entity.UserMenu;

public interface UserMenuRepository extends JpaRepository<UserMenu, Long> {

    Optional<UserMenu> findById(Long i);

    List<UserMenu> findByUserGroupMap(UserGroupMap userGroupMap);

}
