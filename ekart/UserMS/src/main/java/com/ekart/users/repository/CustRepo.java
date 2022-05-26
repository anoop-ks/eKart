package com.ekart.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.users.entity.Customer;

@Repository
public interface CustRepo extends JpaRepository<Customer, Long> {
	
	List<Customer> findByUsername(String username);
}
