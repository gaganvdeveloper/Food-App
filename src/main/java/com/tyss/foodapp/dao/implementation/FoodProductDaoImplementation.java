package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.FoodProductDao;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.util.MyEntityManager;

public class FoodProductDaoImplementation implements FoodProductDao {
//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		if (foodProduct != null) {
			transaction.begin();
			manager.persist(foodProduct);
			transaction.commit();
			return foodProduct;
		}
		return null;
	}

	@Override
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		if (foodProduct != null) {
			transaction.begin();
			manager.merge(foodProduct);
			transaction.commit();
			return foodProduct;
		}
		return null;
	}

	@Override
	public FoodProduct findFoodProduct(int id) {
		return manager.find(FoodProduct.class, id);
	}

	@Override
	public boolean deleteFoodProduct(int id) {
		FoodProduct foodProduct = findFoodProduct(id);
		if (foodProduct != null) {
			transaction.begin();
			manager.remove(foodProduct);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Object findFoodProductByName(String name) {
		Query query = manager.createNamedQuery("select f from FoodProduct f where f.name=?1");
		try {
			return (FoodProduct) query.getSingleResult();
		} catch (NoResultException e) {
			return "Unable To Find FoodProduct for given Name " + name;
		}
	}
}
