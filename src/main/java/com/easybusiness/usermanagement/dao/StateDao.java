
package com.easybusiness.usermanagement.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.usermanagement.entity.State;
import com.easybusiness.usermanagement.repository.StateRepository;

@Component
public class StateDao {

	@Autowired
	StateRepository stateRepository;
	
	@Transactional 
	public State getStateById(long id) {
		return stateRepository.findById(id);
	}
	
}
