package com.tyss.foodapp.service.implementation;

import java.util.List;

import com.tyss.foodapp.dao.implementation.FoodOrderDaoImplementation;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.FoodOrderService;

public class FoodOrderServiceImplementation implements FoodOrderService {

	FoodOrderDaoImplementation dao = new FoodOrderDaoImplementation();

	@Override
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return dao.saveFoodOrder(foodOrder);
	}

	@Override
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return dao.updateFoodOrder(foodOrder);
	}

	@Override
	public FoodOrder findFoodOrderById(int id) {
		return dao.findFoodOrder(id);
	}

	@Override
	public boolean deleteFoodOrderById(int id) {
		return dao.deleteFoodOrder(id);
	}

	@Override
	public double calculateTotalFoodOrderPrice(FoodOrder foodOrder) {
		double totalPrice = 0.0;
		for (Item item : foodOrder.getItems()) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	@Override
	public List<FoodOrder> findAllFoodOrders() {
		return dao.findAllFoodOrders();
	}

}
