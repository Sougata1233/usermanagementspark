package com.easybusiness.usermanagement.services.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.dao.DesignationDao;
import com.easybusiness.usermanagement.entity.Designation;
import com.easybusiness.usermanagement.services.DesignationService;


/*
 * Service and RestController class for DESIGNATION
 */
@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationDao desigDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.designation.DesignationService#getDesignationByName(java.lang.String)
     * fetching designation by desigName
     * GET method for DESIGNATION table with param desigName
     */
    @Override
    public DesignationDto getDesignationByName(String desigName) {

	Designation dept = desigDao.findByDesigName(desigName.toUpperCase());
	return prepareDesignationDetails(dept);
    }

    
    /*
     * preparing DesignationDTO from Designation entity
     */
    private DesignationDto prepareDesignationDetails(Designation desig) {
    	DesignationDto DesignationDTO = new DesignationDto();
	DesignationDTO.setId(desig.getId());
	DesignationDTO.setDesig(desig.getDesig());
	return DesignationDTO;
    }

    @Override
    public List<DesignationDto> getDesignationAsPerCriteria(String whereClause) {

	return null;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.designation.DesignationService#addDesignation(com.easybusiness.usermanagement.DTO.DesignationDto)
     * saving designation to database 
     * POST method for DESIGNATION table with DesignationDTO request body
     */
    @Override
    public ResponseEntity<DesignationDto> addDesignation(DesignationDto desigModel) {
//    	if(desigModel.getId() == 0) {
    		desigDao.addDesignation(prepareDesignationEntity(desigModel));
//    	}else {
//    		System.out.println("inside else");
//    		Designation desig = desigDao.findDesignationById(desigModel.getId()).get();
//    		desig.setDesig(desigModel.getDesig());
//    		desig.setModBy(desigModel.getModBy());
//    		desig.setModOn(Date.valueOf(LocalDate.now()));
//    		desigDao.addDesignation(desig);
//    	}
	
	
	return new ResponseEntity<DesignationDto>(desigModel, HttpStatus.CREATED);

    }

    /*
     * preparing DesignationEntity from DesignationDTO
     */
    private Designation prepareDesignationEntity(DesignationDto desigDTO) {
	Designation desigEntity = new Designation();
	desigEntity.setDesig(desigDTO.getDesig());
	desigEntity.setModOn(Date.valueOf(LocalDate.now()));
	return desigEntity;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.designation.DesignationService#getAllDesignations()
     * fetching all designatons
     * GET method for DESIGNATION table
     */
    @Override
    public List<DesignationDto> getAllDesignations() throws Exception {
	List<Designation> deptList = desigDao.findAll();
	List<DesignationDto> deptModelList = new ArrayList<DesignationDto>();
	deptList.forEach(deptEntity -> {
		DesignationDto desigModel = new DesignationDto();
	    desigModel = prepareDesignationDetails(deptEntity);
	    deptModelList.add(desigModel);

	});
	return deptModelList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.designation.DesignationService#getDesignationById(java.lang.Long)
     * fetching Designation by desigId
     * GET method for DESIGNATION table with param desigId
     */
    @Override
    public DesignationDto getDesignationById(Long desigId) {

	return prepareDesignationDetails(desigDao.findDesignationById(desigId).get());
    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.designation.DesignationService#deleteDesignation(java.lang.Long)
     * deleting designation by desigId
     * DELETE method for DESIGNATION table with param desigId
     */
    @Override
    public ResponseEntity<DesignationDto> deleteDesignation(Long desigId) {

	// deptMenuDao.deleteDesignationMenuByDesignationId(deptId);
	Designation desig = desigDao.findDesignationById(desigId).get();
	desigDao.deleteDesignation(desigId);
	return new ResponseEntity<DesignationDto>(prepareDesignationDetails(desig), HttpStatus.OK);

    }

}
