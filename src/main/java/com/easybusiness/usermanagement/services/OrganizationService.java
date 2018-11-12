package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.OrganizationDto;

public interface OrganizationService {

    public OrganizationDto getOrganizationByName(String orgName);

    public List<OrganizationDto> getOrganizationAsPerCriteria(String whereClause);

    public ResponseEntity<OrganizationDto> addOrganization(OrganizationDto organization);

    public List<OrganizationDto> getAllOrganizations() throws Exception;

    public OrganizationDto getOrganizationById(Long organizationId);

    public ResponseEntity<OrganizationDto> deleteOrganization(Long organizationId);


}
