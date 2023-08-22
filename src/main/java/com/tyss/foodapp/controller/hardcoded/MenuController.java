package com.tyss.foodapp.controller.hardcoded;

import java.util.Arrays;

import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dao.implementation.UserDaoImplementation;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.service.implementation.MenuServiceImplementation;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;

public class MenuController {
	public static void main(String[] args) {
//		MenuDaoImplementation menudao = new MenuDaoImplementation();
//		UserDaoImplementation userdao = new UserDaoImplementation();

		UserServiceImplementation uservice = new UserServiceImplementation();
		
		MenuServiceImplementation service = new MenuServiceImplementation();
		
		
		
		Menu menu = new Menu();
		menu.setUser(uservice.findUserById(1));
		menu.setFoodProducts(Arrays.asList(new FoodProduct()));
		menu = service.saveMenu(menu);
		System.out.println("Menu Saved Successfully..."+menu);
		
		
		
//		Menu menu = menudao.findMenu(1);
//		if(menu != null) {
//			System.out.println("Menu Found Successfully..."+menu);
//		}
		
		
//		Menu menu = menudao.findMenu(1);
//		if(menu != null) {
//			menu.setUser(userdao.findUser(9));
//			menu.setFoodProducts(Arrays.asList(new FoodProduct(), new FoodProduct(), new FoodProduct()));
//			System.out.println("Menu Updated Successfully..."+menu);
//		}
		
		
//		if(menudao.deleteMenu(3)) {
//			System.out.println("Menu deleted Successfully...");
//		}else 
//			System.out.println("Invalid Menu ID : ");
		
		
		
		
		
		
		
	}
}
