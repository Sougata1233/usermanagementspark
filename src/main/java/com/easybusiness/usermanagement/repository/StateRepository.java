package com.easybusiness.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {

	State findById(long id);
	
}
