package com.easybusiness.usermanagement.services.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.easybusiness.usermanagement.DTO.UserProfessionDTO;
import com.easybusiness.usermanagement.dao.UserProfessionDao;
import com.easybusiness.usermanagement.entity.UserProfession;
import com.easybusiness.usermanagement.services.UserProfessionService;

@Service
public class UserProfessionServiceImpl implements UserProfessionService {
	
	@Autowired
    UserProfessionDao userProfessionDao;

	/*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.user.UserService#persistUserProfession(com.easybusiness.usermanagement.DTO.UserProfessionDTO)
     * saving user profession to DB
     * POST method for user_profession table with request body "UserProfessionDTO"
     */
	@Override
    public ResponseEntity<UserProfessionDTO> persistUserProfession(UserProfessionDTO userProfession) {
	
		if(userProfession.getId() == 0) {
		UserProfession userProfessionValue = new UserProfession();
		System.out.println("user profession DTO to be sent to Dao is " + userProfession.toString());
		
		userProfessionValue.setModBy(userProfession.getModBy());
		userProfessionValue.setModOn(Date.valueOf(LocalDate.now()));
		userProfessionValue.setOrganization(userProfession.getOrganization());
		userProfessionValue.setOtherSkill(userProfession.getOtherSkill());
		userProfessionValue.setPrimarySkill(userProfession.getPrimarySkill());
		userProfessionValue.setProjectDesc(userProfession.getProjectDesc());
		userProfessionValue.setProjectDuration(userProfession.getProjectDuration());
		userProfessionValue.setProjectEndDate(userProfession.getProjectEndDate());
		userProfessionValue.setProjectName(userProfession.getProjectName());
		userProfessionValue.setProjectRole(userProfession.getProjectRole());
		userProfessionValue.setProjectStartDate(userProfession.getProjectStartDate());
		userProfessionValue.setUser(userProfession.getUser());

		userProfessionDao.addUserProfession(userProfessionValue);
		}else {
		UserProfession userProfessionValue = userProfessionDao.getProfessionById(userProfession.getId());
		System.out.println("user profession DTO to be sent to Dao is " + userProfession.toString());
		
		userProfessionValue.setModBy(userProfession.getModBy());
		userProfessionValue.setModOn(Date.valueOf(LocalDate.now()));
		userProfessionValue.setOrganization(userProfession.getOrganization());
		userProfessionValue.setOtherSkill(userProfession.getOtherSkill());
		userProfessionValue.setPrimarySkill(userProfession.getPrimarySkill());
		userProfessionValue.setProjectDesc(userProfession.getProjectDesc());
		userProfessionValue.setProjectDuration(userProfession.getProjectDuration());
		userProfessionValue.setProjectEndDate(userProfession.getProjectEndDate());
		userProfessionValue.setProjectName(userProfession.getProjectName());
		userProfessionValue.setProjectRole(userProfession.getProjectRole());
		userProfessionValue.setProjectStartDate(userProfession.getProjectStartDate());
		userProfessionValue.setUser(userProfession.getUser());

		userProfessionDao.addUserProfession(userProfessionValue);
	}
	return new ResponseEntity<UserProfessionDTO>(userProfession, HttpStatus.CREATED);
    }


	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.user.UserService#updateUserProfession(com.easybusiness.usermanagement.DTO.UserProfessionDTO)
	 * updating user profession
	 * POST method for user_profession table with request body UserProfessionDTO
	 * this method updates the user profession finding by profession id
	 */
    @Override
    public ResponseEntity<UserProfessionDTO> updateUserProfession(
    		@RequestBody UserProfessionDTO userProfession) {
	

    	if(userProfession.getId() == 0) {
    		UserProfession userProfessionValue = new UserProfession();
    		System.out.println("user profession DTO to be sent to Dao is " + userProfession.toString());
    		
    		userProfessionValue.setModBy(userProfession.getModBy());
    		userProfessionValue.setModOn(Date.valueOf(LocalDate.now()));
    		userProfessionValue.setOrganization(userProfession.getOrganization());
    		userProfessionValue.setOtherSkill(userProfession.getOtherSkill());
    		userProfessionValue.setPrimarySkill(userProfession.getPrimarySkill());
    		userProfessionValue.setProjectDesc(userProfession.getProjectDesc());
    		userProfessionValue.setProjectDuration(userProfession.getProjectDuration());
    		userProfessionValue.setProjectEndDate(userProfession.getProjectEndDate());
    		userProfessionValue.setProjectName(userProfession.getProjectName());
    		userProfessionValue.setProjectRole(userProfession.getProjectRole());
    		userProfessionValue.setProjectStartDate(userProfession.getProjectStartDate());
    		userProfessionValue.setUser(userProfession.getUser());

    		userProfessionDao.addUserProfession(userProfessionValue);
    		}else {
    		UserProfession userProfessionValue = userProfessionDao.getProfessionById(userProfession.getId());
    		System.out.println("user profession DTO to be sent to Dao is " + userProfessionValue.toString());
    		
    		userProfessionValue.setModBy(userProfession.getModBy());
    		userProfessionValue.setModOn(Date.valueOf(LocalDate.now()));
    		userProfessionValue.setOrganization(userProfession.getOrganization());
    		userProfessionValue.setOtherSkill(userProfession.getOtherSkill());
    		userProfessionValue.setPrimarySkill(userProfession.getPrimarySkill());
    		userProfessionValue.setProjectDesc(userProfession.getProjectDesc());
    		userProfessionValue.setProjectDuration(userProfession.getProjectDuration());
    		userProfessionValue.setProjectEndDate(userProfession.getProjectEndDate());
    		userProfessionValue.setProjectName(userProfession.getProjectName());
    		userProfessionValue.setProjectRole(userProfession.getProjectRole());
    		userProfessionValue.setProjectStartDate(userProfession.getProjectStartDate());
    		userProfessionValue.setUser(userProfession.getUser());

    		userProfessionDao.addUserProfession(userProfessionValue);
    	}
	
	return new ResponseEntity<UserProfessionDTO>(userProfession, HttpStatus.CREATED);
    }


	/*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.user.UserService#getUserProfession(java.lang.Long)
     * fetching user profession from user_profession table
     * GET method with param userId
     */
	@Override
	public List<UserProfessionDTO> getUserProfession(Long userId) {
		System.out.println("in get user Profession");
		List<UserProfession> userProfessionEntity = userProfessionDao.getUserProfessionByUser(userId);
		List<UserProfessionDTO> userProfessionDTO = new ArrayList<>();
		if (null != userProfessionEntity) {

		    userProfessionEntity.forEach(userProfession->{
		    	userProfessionDTO.add(prepareUserProfessionDTO(userProfession));
		    	System.out.println("profession "+userProfession);
		    });

		}
		return userProfessionDTO;
	}
	


    
    /*
     * preparing user profession DTO for fetching user profession data
     */
    private UserProfessionDTO prepareUserProfessionDTO(UserProfession userProfession) {
    	
    	UserProfessionDTO userProfessionDTO = new UserProfessionDTO();
    	
    	long startDate =  userProfession.getProjectStartDate().getTime();
    	long endDate =  userProfession.getProjectEndDate().getTime();
    	String diff = "";
    	long timeDiff = (endDate-startDate);
    	diff = String.format("%d months", TimeUnit.MILLISECONDS.toDays(timeDiff)/30);
    	userProfessionDTO.setTotalExp(diff);
    	
    	userProfessionDTO.setId(userProfession.getId());
    	userProfessionDTO.setModBy(userProfession.getModBy());
    	userProfessionDTO.setModOn(userProfession.getModOn());
    	userProfessionDTO.setOrganization(userProfession.getOrganisation());
    	userProfessionDTO.setOtherSkill(userProfession.getOtherSkill());
    	userProfessionDTO.setPrimarySkill(userProfession.getPrimarySkill());
    	userProfessionDTO.setProjectDesc(userProfession.getProjectDesc());
    	userProfessionDTO.setProjectDuration(userProfession.getProjectDuration());
    	userProfessionDTO.setProjectEndDate(userProfession.getProjectEndDate());
    	userProfessionDTO.setProjectName(userProfession.getProjectName());
    	userProfessionDTO.setProjectRole(userProfession.getProjectRole());
    	userProfessionDTO.setProjectStartDate(userProfession.getProjectStartDate());
    	userProfessionDTO.setUser(userProfession.getUser());
	    
	    
		return userProfessionDTO;
	}


}
