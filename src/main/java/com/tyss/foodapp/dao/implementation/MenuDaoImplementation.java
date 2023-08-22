package com.tyss.foodapp.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.MenuDao;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.util.MyEntityManager;

public class MenuDaoImplementation implements MenuDao {

//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public Menu saveMenu(Menu menu) {
		if (menu != null) {
			transaction.begin();
			manager.persist(menu);
			transaction.commit();
			return menu;
		}
		return null;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		if (menu != null) {
			transaction.begin();
			manager.merge(menu);
			transaction.commit();
			return menu;
		}
		return null;
	}

	@Override
	public Menu findMenu(int id) {
		return manager.find(Menu.class, id);
	}

	@Override
	public boolean deleteMenu(int id) {
		Menu menu = findMenu(id);
		if (menu != null) {
			transaction.begin();
			manager.remove(menu);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Menu> findAll() {
		Query query = manager.createQuery("from Menu m");
		return query.getResultList();
	}

}
