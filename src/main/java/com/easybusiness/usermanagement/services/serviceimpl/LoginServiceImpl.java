package com.easybusiness.usermanagement.services.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.dao.UserLoginDetailsDao;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserLoginDetails;
import com.easybusiness.usermanagement.services.LoginService;
import com.google.common.hash.Hashing;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
    UserLoginDetailsDao loginDao;
	
	@Autowired
    UserDao userDao;
	
	/*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.user.UserService#LogoutUser(java.lang.String)
     * logging out user
     * this method logs out the user and set isActive field of user_login_details to N thus invalidates the login token 
     */
	@Override
	public UserLoginDetails LogoutUser(String loginToken) throws Exception {
		
			loginDao.updateLoginDetails(loginToken);
			
		return loginDao.getLoginDetailsByLoginToken(loginToken);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.user.UserService#getLoginDetails(java.lang.String, java.lang.String)
	 * login method for user
	 * this method takes username and password as param from the user and compares them with the existing username and
	 * password data in the user_details table, if this validation succeeds then the user can login and a login token 
	 * will be generated and stored in db in the table user_login_details with the fiels isActive having value Y
	 */
	@Override
	public UserLoginDetails getLoginDetails(String userName,
												 String password) throws Exception {
		User userEntity = userDao.findByUserNameStream(userName).get(0);
		UserLoginDetails login = loginDao.getLoginDetailsByUserId(userName).get(0);
		/*String tokenId = login.getLoginToken();
		UserLoginDetails loginVerify = loginDao.getLoginDetailsByLoginToken(tokenId);*/
		UserLoginDetails loginSave = new UserLoginDetails();
		
		//getting password from user and comparing with original passoword
		String originalPassword = userEntity.getPassword();
		String hashedpass = Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)
				.toString();
		
		/*SecureRandom random = new SecureRandom();
		long longToken = Math.abs(random.nextLong());
		String random1 = Long.toString(longToken, 16);
		String token1 = userEntity.getUserName().toUpperCase()+ random.hashCode();*/
		
		//generating login token for logging in
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 18) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        System.out.println("length "+saltStr.length()+" token "+saltStr);
		
		/*DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		        .appendPattern("MM").appendLiteral("")
		        .appendPattern("dd").appendLiteral("")
		        .appendPattern("yyyy").appendLiteral("")
		        .appendPattern("hh").appendLiteral("")
		        .appendPattern("mm").appendLiteral("")
		        .appendPattern("ss").appendLiteral("")
		        .appendPattern("a")
		        .toFormatter();
		String token = UUID.randomUUID().toString().toUpperCase() + LocalDateTime.now().format(formatter);*/
		
		if(login.getIsActive().equals("N") || login == null) {   //checking if user is already logged in or not
			if(hashedpass.equalsIgnoreCase(userEntity.getPassword())) {   //matching password
				
				LocalDate date = LocalDate.now();
				
				loginSave.setFirstName(userEntity.getFirstName());
				loginSave.setLastName(userEntity.getLastName());
				loginSave.setUserId(userEntity.getId());
				loginSave.setLastModifiedDate(Date.valueOf(date));
				loginSave.setCreateDate(Date.valueOf(date));
				loginSave.setIsActive("Y");
				loginSave.setUserName(userEntity.getUserName());
				loginSave.setCounter(login.getCounter()+1);
				loginSave.setLoginToken(saltStr);
				
				loginDao.saveLoginDetails(loginSave);
				System.out.println(Server.START_EVENT.length());
				System.out.println("inside login success");
			}else {
				System.out.println("inside login failed due to wrong password");
				return loginSave;
			}
		}else {
			System.out.println("inside login fail");
			System.out.println(login.getIsActive());
			return loginSave;
		}
		return loginSave;
	}


}
