package com.tyss.foodapp.controller.hardcoded;

import com.tyss.foodapp.dao.implementation.ItemDaoImplementation;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.Type;

public class ItemController {
	public static void main(String[] args) {
		
//		ItemDaoImplementation itemdao = new ItemDaoImplementation();
		ItemServiceImplementation service = new ItemServiceImplementation();
		
		
		Item item =new Item();
		item.setName("Dosa");
		item.setPrice(60.02);
		item.setQuantity(2);
		item.setType(Type.VEG);
		item.setProductId(3);
		Item item1 = service.saveItem(item);
		if(item1 != null)
			System.out.println("Item Saved Successfully..."+item1);
		else
			System.out.println("Unable to save item...");
		
		
		
//		Item item = service.findItemById(1);
//		if(item !=null)
//		System.out.println("Item Found Successfull..."+item);
//		else
//			System.out.println("Unable to find item...");
		
		
		
//		Item item = itemdao.findItem(2);
//		if(item != null) {
//			item.setPrice(50.8);
//			itemdao.updateItem(item);
//			System.out.println("Item Updated Successfully... "+item);
//		}
//		else {
//			System.out.println("Invalid Item ID ");
//		}
		
		
		
//		if(itemdao.deleteItem(4)) {
//			System.out.println("Item Deleted Successfully...");
//		}
//		else
//			System.out.println("Unable to Delete Item");
		
		
		
		
		
	}
}
