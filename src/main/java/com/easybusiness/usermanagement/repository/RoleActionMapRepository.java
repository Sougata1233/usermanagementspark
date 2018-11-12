package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Role;
import com.easybusiness.usermanagement.entity.RoleActionMap;

public interface RoleActionMapRepository extends JpaRepository<RoleActionMap, Long>{

    Optional<RoleActionMap> findById(Long i);

    List<RoleActionMap> findByRole(Role role);

}
