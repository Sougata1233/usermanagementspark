package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.DepartmentDto;;

public interface DepartmentService {

    public DepartmentDto getDepartmentByName(String deptName);

    public List<DepartmentDto> getDepartmentAsPerCriteria(String whereClause);

    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto department);

    public List<DepartmentDto> getAllDepartments() throws Exception;

    public DepartmentDto getDepartmentById(Long departmentId);

    public ResponseEntity<DepartmentDto> deleteDepartment(Long departmentId);

    List<DepartmentDto> getAllDepartmentsByOrganization(Long orgId) throws Exception;


}
