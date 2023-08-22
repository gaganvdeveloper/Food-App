package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.FoodOrder;

public interface FoodOrderDao {

	public FoodOrder saveFoodOrder(FoodOrder foodOrder);

	public FoodOrder updateFoodOrder(FoodOrder foodOrder);

	public FoodOrder findFoodOrder(int id);

	public boolean deleteFoodOrder(int id);

}
