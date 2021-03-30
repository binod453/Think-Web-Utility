package com.mps.think.utility.daoImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.utility.dao.UserInfoDAO;
import com.mps.think.utility.model.LoginModel;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Override
	public LoginModel getActiveUser(String userName) {
		LoginModel activeUserInfo = new LoginModel();
		activeUserInfo.setUsername(userName);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		activeUserInfo.setPassword("1");
		activeUserInfo.setRole("SUPER");		
		return activeUserInfo;
	}
	
} 

