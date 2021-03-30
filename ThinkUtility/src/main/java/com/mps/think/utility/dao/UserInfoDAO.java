package com.mps.think.utility.dao;

import com.mps.think.utility.model.LoginModel;

public interface  UserInfoDAO {
	
	LoginModel getActiveUser(String userName);

}
