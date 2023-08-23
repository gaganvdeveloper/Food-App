package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.Item;

public interface ItemService {

	Item saveItem(Item Item);

	Item updateItem(Item Item);

	Item findItemById(int id);

	boolean deleteItemById(int id);

	List<Item> findAllItems();
}
