package com.tyss.foodapp.controller.hardcoded;

import java.util.List;

import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;

public class FoodOrderController {

	public static void main(String[] args) {
		
		FoodOrderServiceImplementation service = new FoodOrderServiceImplementation();
		
		ItemServiceImplementation iservice = new ItemServiceImplementation();
		
		
//		FoodOrderDaoImplementation fdao = new FoodOrderDaoImplementation();
		
//		FoodOrder foodOrder = new FoodOrder();
//		foodOrder.setCustomerName("Shubham");
//		foodOrder.setContactNumber(7813040123l);
//		foodOrder.setStatus(Status.ONTHEWAY);
//		foodOrder.setItems(Arrays.asList(iservice.findItemById(1),iservice.findItemById(2),iservice.findItemById(3)));
//		foodOrder.setTotalPrice(service.calculateTotalFoodOrderPrice(foodOrder));
//		service.saveFoodOrder(foodOrder);
		
	
//		System.out.println("Food Order Found... ====> "+fdao.findFoodOrder(2));
	
//		System.out.println("Food Order Deleted ===> "+fdao.deleteFoodOrder(3));
	
		
//		FoodOrder foodOrder = fdao.findFoodOrder(2);
//		
//		foodOrder.setItems(Arrays.asList(new Item(), new Item()));
//		
//		System.out.println("Food Order Updated ===> "+fdao.updateFoodOrder(foodOrder));
		
		
		FoodOrder foodOrder = service.findFoodOrderById(1);
		System.out.println(foodOrder);
		
		List<Item> items = foodOrder.getItems();
		
		items.add(iservice.findItemById(5));
		foodOrder.setItems(items);

		foodOrder.setTotalPrice(service.calculateTotalFoodOrderPrice(foodOrder));
		
		service.updateFoodOrder(foodOrder);
		System.out.println("Updated---===>>> "+foodOrder);
		
	
	}

	
	
	
	
	
}
