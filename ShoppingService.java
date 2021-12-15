package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.Shopping;

public interface ShoppingService {
	Shopping createItem(Shopping item);
	
	List<Shopping> getAllItems();
	List<Shopping> getAllItemsByName(String itemName);
	List<Shopping> getAllItemsByPrice(Double itemPrice);
	Shopping getItem(Integer itemId);
	Shopping replaceItem(Integer itemId, Shopping newItem);
	void removeItem(Integer itemId);
}

