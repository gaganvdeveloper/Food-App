package com.tyss.foodapp.controller.hardcoded;

import java.util.Arrays;

import com.tyss.foodapp.dao.UserDao;
import com.tyss.foodapp.dao.implementation.UserDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;

public class UserController{

	public static void main(String[] args) {

		UserServiceImplementation service = new UserServiceImplementation();
//		UserDaoImplementation dao = new UserDaoImplementation();

		User user = new  User();
		user.setName("Gagan V");
		user.setEmail("gaganvdeveloper@gmail.com");
		user.setPassword("Gaganv123");
		user.setRole(Role.CUSTOMER);
		user.setBranchs(Arrays.asList(new Branch()));
		user.setFoodOrders(Arrays.asList(new FoodOrder(),new FoodOrder()));
		user.setMenu(new Menu());
		if(service.saveUser(user) != null) {
			System.out.println("User Saved Properly..."+user);
		}
		else
			System.out.println("Unable to save User");

//		User user = dao.findUser(6);
//		if(user != null)
//		System.out.println("User Found Successfully..."+user);

//		User user = dao.findUser(8);
//		user.setName("Abhishek S");
//		user.setEmail("abhisheks@gmail.com");
//		user.setRole(Role.CUSTOMER);
//		user.setPassword("Abhisheks123");
//		user.setEmail("gaganvdeveloper@gmail.com");
//		user.setPassword("Gaganv!@#");
//		dao.updateUser(user);
//		System.out.println("User Updated Successfully..."+user);

//		if (dao.deleteUser(7)) {
//			System.out.println("User deleted Successfully...");
//		} else
//			System.out.println("Invalid User ID");

//		User user = dao.verifyUser("gaganvdeveloper@gmail.com", "Gaganv!@#");
//		if(user != null)
//			System.out.println("User Verified Successfully... "+user);
//		else
//			System.out.println("Invalid User Credentils");

	}

}
