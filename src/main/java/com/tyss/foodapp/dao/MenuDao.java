package com.tyss.foodapp.dao;

import java.util.List;

import com.tyss.foodapp.dto.Menu;

public interface MenuDao {

	public Menu saveMenu(Menu menu);

	public Menu updateMenu(Menu menu);

	public Menu findMenu(int id);

	public boolean deleteMenu(int id);
	
	List<Menu> findAll();
}
