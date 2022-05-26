package com.ekart.kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.kart.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Long>{

}
