package com.easybusiness.usermanagement.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.usermanagement.entity.Country;
import com.easybusiness.usermanagement.repository.CountryRepository;

@Component
public class CountryDao {
	
	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public Country getCountryById(long id) {
		return countryRepository.findById(id);
	}
	
}
