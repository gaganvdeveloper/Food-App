package com.tyss.foodapp.service;

import com.tyss.foodapp.dto.User;

public interface UserService {

	User saveUser(User user);

	User updateUser(User user);

	User findUserById(int id);

	User findUserByUsername(String username);

	User findUserByEmail(String email);

//	User findUserByPhone(long phone);

	boolean deleteUserById(int id);

	User verifyUserByEmailAndPassword(String email, String password);

}
