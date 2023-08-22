package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.Menu;

public interface MenuService {

	Menu saveMenu(Menu menu);

	Menu updateMenu(Menu menu);

	Menu findMenuById(int id);

	boolean deleteMenu(int id);

	Object findMenuByBranchId(int id);

	Menu findMenuByUserId(int id);

	List<Menu> findAllMenus();

}
