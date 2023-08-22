package com.tyss.foodapp.service.implementation;

import com.tyss.foodapp.dao.implementation.ItemDaoImplementation;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.ItemService;

public class ItemServiceImplementation implements ItemService {

	ItemDaoImplementation dao = new ItemDaoImplementation();

	@Override
	public Item saveItem(Item Item) {
		return dao.saveItem(Item);
	}

	@Override
	public Item updateItem(Item Item) {
		return dao.updateItem(Item);
	}

	@Override
	public Item findItemById(int id) {
		return dao.findItem(id);
	}

	@Override
	public boolean deleteItemById(int id) {
		return dao.deleteItem(id);
	}

}
