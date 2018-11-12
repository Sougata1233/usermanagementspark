package com.easybusiness.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.entity.UserLoginDetails;

public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {

	UserLoginDetails findByLoginToken(String loginToken);
	
	@Query("select l from UserLoginDetails l where l.userName = :userName")
	List<UserLoginDetails> findByUserLoginId(@Param("userName") String userName);
	
}
