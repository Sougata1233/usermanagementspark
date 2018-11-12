package com.easybusiness.usermanagement.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.repository.LocationMasterRepository;

/*
 * DAO class for LOCATION_MASTER table
 */

@Component
public class LocationMasterDao {
	
	@Autowired
	LocationMasterRepository locationRepository;
	
	@Transactional
	public LocationMaster getLocationById(long id) {
		return locationRepository.findOne(id);
	}

}
