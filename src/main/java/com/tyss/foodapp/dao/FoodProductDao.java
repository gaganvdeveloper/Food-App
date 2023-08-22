package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.FoodProduct;

public interface FoodProductDao {

	public FoodProduct saveFoodProduct(FoodProduct foodProduct);

	public FoodProduct updateFoodProduct(FoodProduct foodProduct);

	public FoodProduct findFoodProduct(int id);

	public boolean deleteFoodProduct(int id);
	
	Object findFoodProductByName(String name);

}
