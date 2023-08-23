package com.tyss.foodapp.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.ItemDao;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.util.MyEntityManager;

public class ItemDaoImplementation implements ItemDao {

//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public Item saveItem(Item item) {
		if (item != null) {
			transaction.begin();
			manager.persist(item);
			transaction.commit();
			return item;
		}
		return null;
	}

	@Override
	public Item updateItem(Item item) {
		if (item != null) {
			transaction.begin();
			manager.merge(item);
			transaction.commit();
			return item;
		}
		return null;
	}

	@Override
	public Item findItem(int id) {
		return manager.find(Item.class, id);
	}

	@Override
	public boolean deleteItem(int id) {
		Item item = findItem(id);
		if (item != null) {
			transaction.begin();
			manager.remove(item);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Item> findAll() {
		Query query = manager.createQuery("from Item i");
		return query.getResultList();
	}

	
}
