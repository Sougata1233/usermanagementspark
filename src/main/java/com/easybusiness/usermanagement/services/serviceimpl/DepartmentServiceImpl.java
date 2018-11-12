package com.easybusiness.usermanagement.services.serviceimpl;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.dao.DepartmentDao;
import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.services.DepartmentService;


/*
 * Service and RestController class for DEPARTMENT table
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#getDepartmentByName(java.lang.String)
     * fetching department by deptName
     * GET method for DEPARTMENT table with param deptName
     */
    @Override
    public DepartmentDto getDepartmentByName(String deptName) {

	Department dept = departmentDao.findByDepartmentName(deptName.toUpperCase());
	return prepareDepartmentDetails(dept);
    }

    
    /*
     * preparing DepartmentDTO from Department entity
     */
    private DepartmentDto prepareDepartmentDetails(Department dept) {
    	DepartmentDto DepartmentDTO = new DepartmentDto();
	DepartmentDTO.setId(dept.getId());
	DepartmentDTO.setDeptName(dept.getDeptName());
	OrganizationDto organizationDTO = new OrganizationDto();
	organizationDTO.setId(dept.getOrganization().getId());
	organizationDTO.setHierarchyId(dept.getOrganization().getHierarchyId());
	organizationDTO.setOrgName(dept.getOrganization().getOrgName());
	organizationDTO.setLocationId(dept.getOrganization().getLocationId());
	organizationDTO.setModBy(dept.getOrganization().getModBy());
	organizationDTO.setModOn(dept.getOrganization().getModOn());
	organizationDTO.setOrgType(dept.getOrganization().getOrgType());
	organizationDTO.setShortCode(dept.getOrganization().getShortCode());
	
	DepartmentDTO.setOrganization(organizationDTO);
	return DepartmentDTO;
    }

    @Override
    public List<DepartmentDto> getDepartmentAsPerCriteria(String whereClause) {

	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#addDepartment(com.easybusiness.usermanagement.DTO.DepartmentDto)
     * saving department to database
     * POST method for DEPARTMENT table with DepartmentDTO request body
     */
    @Override
    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto deptModel) {
    	if(deptModel.getId() == 0) {
    		System.out.println(deptModel.getOrganization());
    		departmentDao.addDepartment(prepareDepartmentEntity(deptModel));
    	}else {
    		Department dept = departmentDao.findDepartmentById(deptModel.getId()).get();
    		
    		dept.setDeptName(deptModel.getDeptName());
    		dept.setModBy(deptModel.getModBy());
    		dept.setModOn(Date.valueOf(LocalDate.now()));
    		dept.setOrganization(prepareOrganizationEntity(deptModel.getOrganization()));
    		
    		departmentDao.addDepartment(dept);
    	}
	
	return new ResponseEntity<DepartmentDto>(deptModel, HttpStatus.CREATED);

    }
    
    /*
     * preparing OrganizationEntity from OrganizationDTO
     */
    private Organization prepareOrganizationEntity(OrganizationDto organizationDTO) {
	Organization orgEntity = new Organization();
	orgEntity.setId(organizationDTO.getId());
	orgEntity.setLocationId(organizationDTO.getLocationId());
	orgEntity.setModBy(organizationDTO.getModBy());
	orgEntity.setOrgType(organizationDTO.getOrgType());
	orgEntity.setShortCode(organizationDTO.getShortCode());
	orgEntity.setHierarchyId(organizationDTO.getHierarchyId());
	orgEntity.setOrgName(organizationDTO.getOrgName());
	return orgEntity;
    }

    
    /*
     * preparing DepartementEntity from DepartmentDTO
     */
    private Department prepareDepartmentEntity(DepartmentDto deptDTO) {
	Department deptEntity = new Department();
	deptEntity.setDeptName(deptDTO.getDeptName());
	Organization organization = new Organization();
	organization.setId(deptDTO.getOrganization().getId());
	organization.setHierarchyId(deptDTO.getOrganization().getHierarchyId());
	organization.setOrgName(deptDTO.getOrganization().getOrgName());
	deptEntity.setOrganization(organization);
	deptEntity.setModOn(Date.valueOf(LocalDate.now()));
	return deptEntity;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#getAllDepartments()
     * fetching all departments
     * GET method for DEPARTMENT table
     */
    @Override
    public List<DepartmentDto> getAllDepartments() throws Exception {
	List<Department> deptList = departmentDao.findAll();
	List<DepartmentDto> deptModelList = new ArrayList<DepartmentDto>();
	deptList.forEach(deptEntity -> {
		DepartmentDto deptModel = new DepartmentDto();
	    deptModel = prepareDepartmentDetails(deptEntity);
	    deptModelList.add(deptModel);

	});
	return deptModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#getDepartmentById(java.lang.Long)
     * fetching department by deptId
     * GET method for DEPARTMENT table with param deptId
     */
    @Override
    public DepartmentDto getDepartmentById(Long deptId) {

	return prepareDepartmentDetails(departmentDao.findDepartmentById(deptId).get());
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#getAllDepartmentsByOrganization(java.lang.Long)
     * fetching department with orgId
     * GET method for DEPARTMENT table with param orgId
     */
    @Override
    public List<DepartmentDto> getAllDepartmentsByOrganization(Long orgId) throws Exception {
	List<Department> deptList = departmentDao.findDepartmentByOrgId(orgId);
	List<DepartmentDto> deptModelList = new ArrayList<DepartmentDto>();
	deptList.forEach(deptEntity -> {
		DepartmentDto deptModel = new DepartmentDto();
	    deptModel = prepareDepartmentDetails(deptEntity);
	    deptModelList.add(deptModel);

	});
	return deptModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.department.DepartmentService#deleteDepartment(java.lang.Long)
     * deleting department bt deptId
     * DELETE method for DEPARTMENT table with param deptId
     */
    @Override
    public ResponseEntity<DepartmentDto> deleteDepartment(Long deptId) {

	// deptMenuDao.deleteDepartmentMenuByDepartmentId(deptId);
	Department dept = departmentDao.findDepartmentById(deptId).get();
	departmentDao.deleteDepartment(deptId);
	return new ResponseEntity<DepartmentDto>(prepareDepartmentDetails(dept), HttpStatus.OK);

    }

}
