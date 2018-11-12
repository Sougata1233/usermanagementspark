package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Organization;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    Optional<Department> findById(Long i);

    List<Department> findByOrganization(Optional<Organization> organization);
    
    List<Department> findByDeptName(String deptName);

}
