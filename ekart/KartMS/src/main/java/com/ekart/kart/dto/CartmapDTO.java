package com.ekart.kart.dto;

import com.ekart.kart.entity.Cart;

public class CartmapDTO {
	
	Long prod_id;
	Long user_id;
	
	
	public Long getProd_id() {
		return prod_id;
	}
	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public static Cart getEntity( CartmapDTO cartmapDTO)
	{
		Cart cart = new Cart();
		
		cart.setProd_id(cartmapDTO.getProd_id());
		cart.setUser_id(cartmapDTO.getUser_id());
		
		return cart;
	}
}
