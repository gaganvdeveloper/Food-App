package com.tyss.foodapp.dao;

import java.util.List;

import com.tyss.foodapp.dto.FoodOrder;

public interface FoodOrderDao {

	public FoodOrder saveFoodOrder(FoodOrder foodOrder);

	public FoodOrder updateFoodOrder(FoodOrder foodOrder);

	public FoodOrder findFoodOrder(int id);

	public boolean deleteFoodOrder(int id);

	public List<FoodOrder> findAllFoodOrders();
}
