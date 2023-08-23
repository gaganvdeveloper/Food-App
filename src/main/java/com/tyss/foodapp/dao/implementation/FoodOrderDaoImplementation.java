package com.tyss.foodapp.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.FoodOrderDao;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.util.MyEntityManager;

public class FoodOrderDaoImplementation implements FoodOrderDao {

//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		if (foodOrder != null) {
			transaction.begin();
			manager.persist(foodOrder);
			transaction.commit();
			return foodOrder;
		}
		return null;
	}

	@Override
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		if (foodOrder != null) {
			transaction.begin();
			manager.merge(foodOrder);
			transaction.commit();
			return foodOrder;
		}
		return null;
	}

	@Override
	public FoodOrder findFoodOrder(int id) {
		return manager.find(FoodOrder.class, id);
	}

	@Override
	public boolean deleteFoodOrder(int id) {
		FoodOrder foodOrder = findFoodOrder(id);
		if (foodOrder != null) {
			transaction.begin();
			manager.remove(foodOrder);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<FoodOrder> findAllFoodOrders() {
		Query query = manager.createQuery("from FoodOrder f");
		return query.getResultList();
	}

}
