package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Shopping;
import com.example.demo.repo.ShoppingRepo;

@Service
public class ShoppingServiceDB implements ShoppingService {
	
	private ShoppingRepo repo;
	
	
	@Autowired
	public ShoppingServiceDB(ShoppingRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Shopping createItem(Shopping item) {
		Shopping created = this.repo.save(item); //INSERT INTO
		return created;
	}

	@Override
	public List<Shopping> getAllItems() {
		return this.repo.findAll(); // SELECT * FROM
	}

	@Override
	public Shopping getItem(Integer itemId) {
		Optional<Shopping> found = this.repo.findById(itemId); // SELECT * FROM ... WHERE ID=
		return found.get();
	}
	
	@Override
	public List<Shopping> getAllItemsByName(String itemName) {
		List<Shopping> found = this.repo.findByItemName(itemName);
		return found;
	}
	
	@Override
	public List<Shopping> getAllItemsByPrice(Double itemPrice) {
		List<Shopping> prices = this.repo.findByItemPrice(itemPrice);
		return prices;
	}	
 
 	@Override
	public Shopping replaceItem(Integer itemId, Shopping newItem) {
		Shopping current = this.repo.findById(itemId).get();
		
		current.setItemName(newItem.getItemName());
		current.setItemPrice(newItem.getItemPrice());
		current.setAisleNumber(newItem.getAisleNumber());
		
		Shopping NewRecord = this.repo.save(current);
		return NewRecord;
	}

	@Override
	public void removeItem(Integer itemId) {
		this.repo.deleteById(itemId); // DELETE FROM ... WHERE ID = ...
	}

}