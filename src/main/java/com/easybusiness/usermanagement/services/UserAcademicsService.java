package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.UserAcademicsDTO;

public interface UserAcademicsService {
	
	List<UserAcademicsDTO> getUserAcademics(Long userId);

    ResponseEntity<UserAcademicsDTO> persistUserAcademics(UserAcademicsDTO userAcademics);

    ResponseEntity<UserAcademicsDTO> updateUserAcademics(UserAcademicsDTO userAcademics);

}
