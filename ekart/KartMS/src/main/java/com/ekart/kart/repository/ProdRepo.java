package com.ekart.kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.kart.entity.Product;

@Repository
public interface ProdRepo extends JpaRepository<Product, Long> {
	
}
