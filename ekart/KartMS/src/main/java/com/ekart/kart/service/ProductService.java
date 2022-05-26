package com.ekart.kart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.kart.dto.CartmapDTO;
import com.ekart.kart.dto.ProdDTO;
import com.ekart.kart.dto.ProductDTO;
import com.ekart.kart.entity.Product;
import com.ekart.kart.repository.CartRepo;
import com.ekart.kart.repository.ProdRepo;

@Service
public class ProductService {
	
	@Autowired
	ProdRepo prodRepo;

	public List<ProdDTO> getprods() {
		
		List<Product> resultEntity = prodRepo.findAll();
		List<ProdDTO> resultDTO = new ArrayList<ProdDTO>();
		
		for(Product p : resultEntity)
		{
			resultDTO.add( ProductDTO.getprodDTO( ProductDTO.getDTO(p) ));
		}
		
		return resultDTO;
	}

	public void add(ProductDTO productDTO) {
		prodRepo.saveAndFlush(ProductDTO.getEntity(productDTO));
	}

	public ProductDTO getdetails(Long id) {
		Optional<Product> pro = prodRepo.findById(id);
		return ProductDTO.getDTO(pro.get());
	}
	
	
	@Autowired
	CartRepo cartRepo;

	public void addtocart(CartmapDTO cartmapDTO) {
		cartRepo.saveAndFlush(CartmapDTO.getEntity(cartmapDTO));
	}
	
	
}
