package com.easybusiness.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findById(long id);
	
}
