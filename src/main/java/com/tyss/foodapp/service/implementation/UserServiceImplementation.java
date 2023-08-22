package com.tyss.foodapp.service.implementation;

import com.tyss.foodapp.dao.implementation.UserDaoImplementation;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.UserService;

public class UserServiceImplementation implements UserService {

	UserDaoImplementation dao = new UserDaoImplementation();

	@Override
	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public User findUserById(int id) {
		return dao.findUser(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public boolean deleteUserById(int id) {
		return dao.deleteUser(id);
	}

	@Override
	public User verifyUserByEmailAndPassword(String email, String password) {
		return dao.verifyUser(email, password);
	}

}
