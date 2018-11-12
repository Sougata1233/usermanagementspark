package com.easybusiness.usermanagement.services.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.UserAcademicsDTO;
import com.easybusiness.usermanagement.dao.UserAcademicsDao;
import com.easybusiness.usermanagement.entity.UserAcademics;
import com.easybusiness.usermanagement.services.UserAcademicsService;

@Service
public class UserAcademicsServiceImpl implements UserAcademicsService {
	
	@Autowired
    UserAcademicsDao userAcademicsDao;

	/*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.user.UserService#getUserAcademics(java.lang.Long)
     * fetching user academics ie user education by user id
     * GET method for user_education table with param userid
     */
    @Override
    public List<UserAcademicsDTO> getUserAcademics(Long userId) {
	System.out.println("in get user Academics");
	List<UserAcademics> userAcademicsEntity = userAcademicsDao
		.getUserAcademics(userId);
	List<UserAcademicsDTO> userAcademicsDTO = new ArrayList<>();
	if (null != userAcademicsEntity) {

	    userAcademicsEntity.forEach(userAcademics->{
	    	userAcademicsDTO.add(prepareUserAcademicsDTO(userAcademics));
	    });

	}
	return userAcademicsDTO;

    }
    
    /*
     * creating user academics DTO for fetching user profession data
     */
    private UserAcademicsDTO prepareUserAcademicsDTO(UserAcademics userAcademics) {
    	UserAcademicsDTO userAcademicsDTO = new UserAcademicsDTO();
    	
    	userAcademicsDTO.setId(userAcademics.getId());
	    userAcademicsDTO.setUser(userAcademics.getUser());
	    userAcademicsDTO.setHighestDegree(userAcademics.getHighestDegree());
	    userAcademicsDTO.setIsValid(userAcademics.getIsValid());
	    userAcademicsDTO.setModBy(userAcademics.getModBy());
	    userAcademicsDTO.setModOn(userAcademics.getModOn());
	    userAcademicsDTO.setPassingYear(userAcademics.getPassingYear());
	    userAcademicsDTO.setUniversity(userAcademics.getUniversity());
	    userAcademicsDTO.setUser(userAcademics.getUser());
	    userAcademicsDTO.setValidity(userAcademics.getValidity());
		
	    return userAcademicsDTO;
	}

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.user.UserService#persistUserAcademics(com.easybusiness.usermanagement.DTO.UserAcademicsDTO)
     * saving user academics data to table user_education table
     * POST method for table user_education with request body UserAcademicsDTO
     */
	@Override
    public ResponseEntity<UserAcademicsDTO> persistUserAcademics(UserAcademicsDTO userAcademics) {

		if(userAcademics.getId() == 0) {
			UserAcademics userAcademicsValue = new UserAcademics();
			System.out.println("user Academics DTO to be sent to Dao is " + userAcademics.toString());
			
			userAcademicsValue.setIsValid(userAcademics.getIsValid());
			userAcademicsValue.setHighestDegree(userAcademics.getHighestDegree());
			userAcademicsValue.setModBy(userAcademics.getModBy());
			userAcademicsValue.setModOn(Date.valueOf(LocalDate.now()));
			userAcademicsValue.setPassingYear(userAcademics.getPassingYear());
			userAcademicsValue.setUniversity(userAcademics.getUniversity());
			userAcademicsValue.setUser(userAcademics.getUser());
			userAcademicsValue.setValidity(userAcademics.getValidity());

			userAcademicsDao.addUserAcademics(userAcademicsValue);
		}else {
			UserAcademics userAcademicsValue = userAcademicsDao.getAcademicsById(userAcademics.getId());
			System.out.println("user Academics DTO to be sent to Dao is " + userAcademics.toString());
			
			userAcademicsValue.setIsValid(userAcademics.getIsValid());
			userAcademicsValue.setHighestDegree(userAcademics.getHighestDegree());
			userAcademicsValue.setModBy(userAcademics.getModBy());
			userAcademicsValue.setModOn(Date.valueOf(LocalDate.now()));
			userAcademicsValue.setPassingYear(userAcademics.getPassingYear());
			userAcademicsValue.setUniversity(userAcademics.getUniversity());
			userAcademicsValue.setUser(userAcademics.getUser());
			userAcademicsValue.setValidity(userAcademics.getValidity());

			userAcademicsDao.addUserAcademics(userAcademicsValue);
		}
	
	return new ResponseEntity<UserAcademicsDTO>(userAcademics, HttpStatus.CREATED);
    }


	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.user.UserService#updateUserAcademics(com.easybusiness.usermanagement.DTO.UserAcademicsDTO)
	 * updating user education
	 * POST method for table user_education with request body UserAacademicsDTO
	 */
    @Override
    public ResponseEntity<UserAcademicsDTO> updateUserAcademics(UserAcademicsDTO userAcademics) {

    	if(userAcademics.getId() != null) {
				UserAcademics userAcademicsValue = userAcademicsDao.getAcademicsById(userAcademics.getId());
				System.out.println("user Academics DTO to be sent to Dao is " + userAcademics.toString());
				userAcademicsValue.setIsValid(userAcademics.getIsValid());
				userAcademicsValue.setHighestDegree(userAcademics.getHighestDegree());
				userAcademicsValue.setModBy(userAcademics.getModBy());
				userAcademicsValue.setModOn(Date.valueOf(LocalDate.now()));
				userAcademicsValue.setPassingYear(userAcademics.getPassingYear());
				userAcademicsValue.setUniversity(userAcademics.getUniversity());
				userAcademicsValue.setUser(userAcademics.getUser());
				userAcademicsValue.setValidity(userAcademics.getValidity());
			
				userAcademicsDao.updateUserAcademics(userAcademicsValue);
    	}else {
    		UserAcademics userAcademicsValue = new UserAcademics();
    		System.out.println("user Academics DTO to be sent to Dao is " + userAcademics.toString());
    		
    		userAcademicsValue.setIsValid(userAcademics.getIsValid());
    		userAcademicsValue.setHighestDegree(userAcademics.getHighestDegree());
    		userAcademicsValue.setModBy(userAcademics.getModBy());
    		userAcademicsValue.setModOn(userAcademics.getModOn());
    		userAcademicsValue.setPassingYear(userAcademics.getPassingYear());
    		userAcademicsValue.setUniversity(userAcademics.getUniversity());
    		userAcademicsValue.setUser(userAcademics.getUser());
    		userAcademicsValue.setValidity(userAcademics.getValidity());

    		userAcademicsDao.addUserAcademics(userAcademicsValue);
    	}
	return new ResponseEntity<UserAcademicsDTO>(userAcademics, HttpStatus.CREATED);
    }

	

}
