package com.ekart.kart.dto;

import com.ekart.kart.entity.Product;

public class ProductDTO {
	
	Long prod_id = 0L;
	String displayName;
	String shortDesc;
	Long discount;
	String category;
	Long price;
	Long quant;
	Long seller_id;
	
	
	

	public Long getProd_id() {
		return prod_id;
	}
	public void setProd_id(Long prod_id) {
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
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	
	public Long getQuant() {
		return quant;
	}
	public void setQuant(Long quant) {
		this.quant = quant;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public static Product getEntity(ProductDTO productDTO)
	{
		Product prod = new Product();
		
		prod.setProd_id(productDTO.getProd_id());
		prod.setDisplayName(productDTO.getDisplayName());
		prod.setDiscount(productDTO.getDiscount());
		prod.setSeller_id(productDTO.getSeller_id());
		prod.setPrice(productDTO.getPrice());
		prod.setQuantityLeft(productDTO.getQuant());
		prod.setShortDesc(productDTO.getShortDesc());
		prod.setCategory(productDTO.getCategory());
		
		return prod;
	}
	
	public static ProdDTO getprodDTO(ProductDTO productDTO)
	{
		ProdDTO prod = new ProdDTO();
		
		prod.setProd_id(productDTO.getProd_id());
		prod.setDisplayName(productDTO.getDisplayName());
		prod.setDiscount(productDTO.getDiscount());
		prod.setShortDesc(productDTO.getShortDesc());
		prod.setCategory(productDTO.getCategory());
		
		return prod;
	}
	
	public static ProductDTO getDTO(Product product)
	{
		ProductDTO prod = new ProductDTO();
		
		prod.setProd_id(product.getProd_id());
		prod.setDisplayName(product.getDisplayName());
		prod.setDiscount(product.getDiscount());
		prod.setSeller_id(product.getSeller_id());
		prod.setPrice(product.getPrice());
		prod.setQuant(product.getQuantityLeft());
		prod.setShortDesc(product.getShortDesc());
		prod.setCategory(product.getCategory());
		
		return prod;
	}
	
	
	
}
