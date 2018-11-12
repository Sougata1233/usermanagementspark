package com.easybusiness.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.entity.LocationMaster;

public interface LocationMasterRepository extends JpaRepository<LocationMaster, Long> {
	
	@Query("select l from LocationMaster l where l.id = :id")
	LocationMasterDTO findById(@Param("id") Long id);

}
