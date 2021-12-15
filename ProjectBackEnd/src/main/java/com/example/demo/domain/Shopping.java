package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Shopping {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;

	@Column(nullable = false)
	private String itemName;

	private Double itemPrice;

	private Integer aisleNumber;

	public Shopping() {
		super();
	}

	public Shopping(Integer itemId, String itemName, Double itemPrice, Integer aisleNumber) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.aisleNumber = aisleNumber;
	}

	public Shopping(String itemName, Double itemPrice, Integer aisleNumber) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.aisleNumber = aisleNumber;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getAisleNumber() {
		return aisleNumber;
	}

	public void setAisleNumber(Integer aisleNumber) {
		this.aisleNumber = aisleNumber;
	}
}
