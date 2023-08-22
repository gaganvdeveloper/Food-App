package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.BranchDaoImplementation;
import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dao.implementation.UserDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.MenuService;

public class MenuServiceImplementation implements MenuService{

	MenuDaoImplementation dao = new MenuDaoImplementation();
	
	@Override
	public Menu saveMenu(Menu menu) {
		return dao.saveMenu(menu);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		return dao.updateMenu(menu);
	}

	@Override
	public Menu findMenuById(int id) {
		return dao.findMenu(id);
	}

	@Override
	public boolean deleteMenu(int id) {
		return dao.deleteMenu(id);
	}

	@Override
	public Object findMenuByBranchId(int id) {
		Branch branch = new BranchDaoImplementation().findBranch(id);
		try {
			return branch.getUser().getMenu();
		}catch(Exception e) {
			return "Unable to find Menu for Given Branch ID";
		}
	}

	@Override
	public Menu findMenuByUserId(int id) {
		User user = new UserDaoImplementation().findUser(id);
		return user.getMenu() ;
	}

	@Override
	public List<Menu> findAllMenus() {
		return dao.findAll();
	}

}
