package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.UserProfessionDTO;

public interface UserProfessionService {
	
	ResponseEntity<UserProfessionDTO> persistUserProfession(UserProfessionDTO userProfession);

    ResponseEntity<UserProfessionDTO> updateUserProfession(UserProfessionDTO userProfession);
    
    List<UserProfessionDTO> getUserProfession(Long userId);
    
  //List<UserProfessionDTO> getUserProfession(String userId);

}
