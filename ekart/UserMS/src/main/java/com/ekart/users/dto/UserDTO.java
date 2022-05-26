package com.ekart.users.dto;

import com.ekart.users.entity.Customer;
import com.ekart.users.entity.Seller;

public class UserDTO {
	
	String username;
	
	String password;
	
	String email_id;
	
	Long phone;
	
	Long id = 0L;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	public Customer getCustEntity() { //--------------------Returns Customer Entity-----------------------------
		Customer Cust = new Customer();
		
		Cust.setCust_id(this.getId());
		Cust.setUsername(this.getUsername());
		Cust.setPassword(this.getPassword());
		Cust.setEmail_id(this.getEmail_id());
		Cust.setPhone(this.getPhone());
		
		return Cust;
	}
	
	public Seller getSellerEntity() { //--------------------Returns Seller Entity-----------------------------
		Seller seller = new Seller();
		
		seller.setSeller_id(this.getId());
		seller.setUsername(this.getUsername());
		seller.setPassword(this.getPassword());
		seller.setEmail_id(this.getEmail_id());
		seller.setPhone(this.getPhone());
		
		return seller;
	}
	
	public static UserDTO getDTOFromSeller(Seller seller) {//---------------Returns DTO----------------------
		
		UserDTO dto = new UserDTO();
		
		dto.setId(seller.getSeller_id());
		dto.setEmail_id(seller.getEmail_id());
		dto.setUsername(seller.getUsername());
		dto.setPhone(seller.getPhone());
		
		return dto;
	}
	
	public static UserDTO getDTOFromCustomer(Customer customer) {//---------------Returns DTO---------------------
		
		UserDTO dto = new UserDTO();
		
		dto.setId(customer.getCust_id());
		dto.setEmail_id(customer.getEmail_id());
		dto.setUsername(customer.getUsername());
		dto.setPhone(customer.getPhone());
		
		return dto;
	}
	
	
	
	
}
