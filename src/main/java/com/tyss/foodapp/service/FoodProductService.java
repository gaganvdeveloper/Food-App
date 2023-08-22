package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.FoodProduct;

public interface FoodProductService {

	FoodProduct saveFoodProduct(FoodProduct foodProduct);

	FoodProduct updateFoodProduct(FoodProduct foodProduct);

	FoodProduct findFoodProductById(int id);

	boolean deleteFoodProductById(int id);

	Object findFoodProductByName(String name);

	List<FoodProduct> findFoodProductByBranchId(int id);

	List<FoodProduct> findFoodProductByMenuId(int id);

}
