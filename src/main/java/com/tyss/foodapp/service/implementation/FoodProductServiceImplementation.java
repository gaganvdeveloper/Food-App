package com.tyss.foodapp.service.implementation;

import java.util.List;

import com.tyss.foodapp.dao.implementation.BranchDaoImplementation;
import com.tyss.foodapp.dao.implementation.FoodProductDaoImplementation;
import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.service.FoodProductService;

public class FoodProductServiceImplementation implements FoodProductService{

	FoodProductDaoImplementation dao = new FoodProductDaoImplementation();
	
	@Override
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return dao.saveFoodProduct(foodProduct);
	}

	@Override
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return dao.updateFoodProduct(foodProduct);
	}

	@Override
	public FoodProduct findFoodProductById(int id) {
		return dao.findFoodProduct(id);
	}

	@Override
	public boolean deleteFoodProductById(int id) {
		return dao.deleteFoodProduct(id);
	}

	@Override
	public Object findFoodProductByName(String name) {
		return dao.findFoodProductByName(name);
	}

	@Override
	public List<FoodProduct> findFoodProductByBranchId(int id) {
		return new BranchDaoImplementation().findBranch(id).getUser().getMenu().getFoodProducts();
	}

	@Override
	public List<FoodProduct> findFoodProductByMenuId(int id) {
		return new MenuDaoImplementation().findMenu(id).getFoodProducts();
	}

	
	
	
	
}
