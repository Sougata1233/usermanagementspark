package com.easybusiness.usermanagement.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.usermanagement.entity.City;
import com.easybusiness.usermanagement.repository.CityRepository;

@Component
public class CityDao {

	@Autowired
	CityRepository cityRepository;
	
	@Transactional
	public City getCityById(long id) {
		return cityRepository.findOne(id);
	}
}
