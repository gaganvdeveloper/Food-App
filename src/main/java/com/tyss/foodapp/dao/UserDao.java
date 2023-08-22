package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.User;

public interface UserDao {

	User saveUser(User user);
	
	User updateUser(User user);
	
	User findUser(int id);
	
	boolean deleteUser(int id);
	
	User verifyUser(String email, String password);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
//	User findByPhone(long phone);
}
