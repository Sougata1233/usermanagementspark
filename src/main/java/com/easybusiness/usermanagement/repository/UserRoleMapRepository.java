package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Role;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserRoleMap;

public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, Long> {

    Optional<UserRoleMap> findById(Long i);

    List<UserRoleMap> findByUser(User user);
    
    List<UserRoleMap> findByRole(Role role);

}
