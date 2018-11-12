package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findById(Long i);

    List<Role> findByRole(String roleName);

    // custom query example and return a stream
    @Query("select r from Role r where r.role = :roleName")
    Stream<Role> findByRoleReturnStream(@Param("roleName") String roleName);

}
