package com.example.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Shopping;
import com.example.demo.service.ShoppingService;

@RestController // tells Spring this is a controller
				// REST compliant
public class ShoppingController {
	
	private ShoppingService service;
	
	@Autowired
	
	public ShoppingController(ShoppingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Shopping> createItem(@RequestBody Shopping item) {
		Shopping created = this.service.createItem(item);
		ResponseEntity<Shopping> response = new ResponseEntity<Shopping>(created, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Shopping>> getAllItems() {
		return ResponseEntity.ok(this.service.getAllItems());
	}

	@GetMapping("/get/{itemId}")
	public Shopping getItem(@PathVariable Integer itemId) {
		return this.service.getItem(itemId);
	}
	
	@GetMapping("/getByName/{itemName}")
	public ResponseEntity<List<Shopping>> getItemByType(@PathVariable String itemName) {
		List<Shopping> found = this.service.getAllItemsByName(itemName);
		return ResponseEntity.ok(found);
	}

	@PutMapping("/replace/{itemId}")
	public ResponseEntity<Shopping> replaceItem(@PathVariable Integer itemId, @RequestBody Shopping newItem) {
		Shopping body = this.service.replaceItem(itemId, newItem);

		ResponseEntity<Shopping> response = new ResponseEntity<Shopping>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{itemId}")
	public ResponseEntity<?> removeItem(@PathVariable Integer itemId) {
		this.service.removeItem(itemId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
