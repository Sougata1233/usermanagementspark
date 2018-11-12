package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.DesignationDto;

public interface DesignationService {

    public DesignationDto getDesignationByName(String desigName);

    public List<DesignationDto> getDesignationAsPerCriteria(String whereClause);

    public ResponseEntity<DesignationDto> addDesignation(DesignationDto designation);

    public List<DesignationDto> getAllDesignations() throws Exception;

    public DesignationDto getDesignationById(Long designationId);

    public ResponseEntity<DesignationDto> deleteDesignation(Long designationId);


}
