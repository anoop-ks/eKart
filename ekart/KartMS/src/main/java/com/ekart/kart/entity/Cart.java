package com.ekart.kart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@GeneratedValue
	@Id
	@Column(name = "cartmap_id")
	long cartmap_id;
	@Column(name = "prod_id")
	long prod_id;
	@Column(name = "user_id")
	long user_id;
	
	
	
	public long getCartmap_id() {
		return cartmap_id;
	}
	public void setCartmap_id(long cartmap_id) {
		this.cartmap_id = cartmap_id;
	}
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
}
