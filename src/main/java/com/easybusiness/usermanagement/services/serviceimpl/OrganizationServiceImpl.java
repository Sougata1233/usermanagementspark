package com.easybusiness.usermanagement.services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.dao.OrganizationDao;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.services.OrganizationService;


/*
 * Service and RestController for ORGANIZATION table
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao orgDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.organization.OrganizationService#getOrganizationByName(java.lang.String)
     * fetching organization by orgName
     * GET method for ORGANIZATION table with param orgName
     */
    @Override
    public OrganizationDto getOrganizationByName(String orgName) {

	Organization org = orgDao.findByOrgName(orgName.toUpperCase());
	return prepareOrganizationDetails(org);
    }

    /*
     * preparing OrganizationDTO from Organization entity
     */
    private OrganizationDto prepareOrganizationDetails(Organization org) {
    	OrganizationDto OrganizationDTO = new OrganizationDto();
	OrganizationDTO.setId(org.getId());
	OrganizationDTO.setOrgName(org.getOrgName());
	OrganizationDTO.setHierarchyId(org.getHierarchyId());
	OrganizationDTO.setLocationId(org.getLocationId());
	OrganizationDTO.setModBy(org.getModBy());
	OrganizationDTO.setModOn(org.getModOn());
	OrganizationDTO.setOrgType(org.getOrgType());
	OrganizationDTO.setShortCode(org.getShortCode());
	return OrganizationDTO;
    }

    @Override
    public List<OrganizationDto> getOrganizationAsPerCriteria(String whereClause) {

	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.organization.OrganizationService#addOrganization(com.easybusiness.usermanagement.DTO.OrganizationDto)
     * saving organization to database
     * POST method for ORGANIZATION table with OrganizationDTO request body
     */
    @Override
    public ResponseEntity<OrganizationDto> addOrganization(OrganizationDto orgModel) {

	orgDao.addOrganization(prepareOrganizationEntity(orgModel));
	return new ResponseEntity<OrganizationDto>(orgModel, HttpStatus.CREATED);

    }

    
    /*
     * preparing OrganizationEntity from OrganizationDTO
     */
    private Organization prepareOrganizationEntity(OrganizationDto organizationDTO) {
	Organization orgEntity = new Organization();
	orgEntity.setHierarchyId(organizationDTO.getHierarchyId());
	orgEntity.setOrgName(organizationDTO.getOrgName());
	return orgEntity;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.organization.OrganizationService#getAllOrganizations()
     * fetching all organizations
     * GET method for ORGANIZATION table
     */
    @Override
    public List<OrganizationDto> getAllOrganizations() throws Exception {
	List<Organization> orgList = orgDao.findAll();
	List<OrganizationDto> orgModelList = new ArrayList<OrganizationDto>();
	orgList.forEach(orgEntity -> {
		OrganizationDto orgModel = new OrganizationDto();
	    orgModel = prepareOrganizationDetails(orgEntity);
	    orgModelList.add(orgModel);

	});
	return orgModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.organization.OrganizationService#getOrganizationById(java.lang.Long)
     * fetching organization by orgid
     * GET method for ORGANIZATION table with param orgid
     */
    @Override
    public OrganizationDto getOrganizationById(Long orgId) {

	return prepareOrganizationDetails(orgDao.findOrganizationById(orgId).get());
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.organization.OrganizationService#deleteOrganization(java.lang.Long)
     * deleting organization by orgid
     * DELETE method for ORGANIZATION table with param orgId
     */
    @Override
    public ResponseEntity<OrganizationDto> deleteOrganization(Long orgId) {

	// orgMenuDao.deleteOrganizationMenuByOrganizationId(orgId);
	Organization org = orgDao.findOrganizationById(orgId).get();
	orgDao.deleteOrganization(orgId);
	return new ResponseEntity<OrganizationDto>(prepareOrganizationDetails(org), HttpStatus.OK);

    }


}
