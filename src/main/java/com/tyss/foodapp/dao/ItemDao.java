package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.Item;

public interface ItemDao {

	public Item saveItem(Item item);

	public Item updateItem(Item item);

	public Item findItem(int id);

	public boolean deleteItem(int id);

}
