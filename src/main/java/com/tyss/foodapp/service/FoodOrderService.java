package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.FoodOrder;

public interface FoodOrderService {

	FoodOrder saveFoodOrder(FoodOrder foodOrder);

	FoodOrder updateFoodOrder(FoodOrder foodOrder);

	FoodOrder findFoodOrderById(int id);

	boolean deleteFoodOrderById(int id);
	
	double calculateTotalFoodOrderPrice(FoodOrder foodOrder);
	
	List<FoodOrder> findAllFoodOrders();
	
}
