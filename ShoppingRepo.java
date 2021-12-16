package com.example.demo.repo;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Shopping;

@Repository
public interface ShoppingRepo extends JpaRepository<Shopping, Integer> {
	//Spring will auto-generate all CRUD functionality.
	List<Shopping> findByItemId(Integer itemId);
	List<Shopping> findByItemName(String itemName);
	List<Shopping> findByItemPrice(Double itemPrice);
	List<Shopping> findByAisleNumber(Integer aisleNumber);
	
	
}
