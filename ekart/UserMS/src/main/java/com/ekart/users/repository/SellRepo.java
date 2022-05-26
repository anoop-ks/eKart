package com.ekart.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.users.entity.Seller;

@Repository
public interface SellRepo extends JpaRepository<Seller,Long> {

	List<Seller> findByUsername(String username);

}
