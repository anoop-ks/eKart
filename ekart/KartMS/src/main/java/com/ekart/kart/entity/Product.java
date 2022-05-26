package com.ekart.kart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	
	@GeneratedValue
	@Id
	@Column(name = "prod_id")
	long prod_id;
	@Column(name = "display_name")
	String displayName;
	@Column(name = "short_desc")
	String shortDesc;
	@Column(name = "category")
	String category;
	@Column(name = "discount")
	long discount;
	@Column(name = "price")
	long price;
	@Column(name = "Quantity_Left")
	long QuantityLeft;
	@Column(name = "Seller")
	long seller_id;
	
	
	
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantityLeft() {
		return QuantityLeft;
	}
	public void setQuantityLeft(long quantityLeft) {
		QuantityLeft = quantityLeft;
	}
	public long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
