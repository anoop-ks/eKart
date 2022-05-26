package com.ekart.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.users.dto.UserDTO;
import com.ekart.users.entity.Customer;
import com.ekart.users.repository.CustRepo;

@Service
public class CustService {
	
	@Autowired
	CustRepo custRepo;
	
	
	
	public void register(UserDTO userdto) {
//		System.out.println("Inside Buyer Register Service");
		custRepo.saveAndFlush(userdto.getCustEntity());
	}

	
	

	public UserDTO login(UserDTO userdto) {
		
		List<Customer> list = custRepo.findByUsername(userdto.getUsername());
		
		UserDTO result = null;
		
		for(Customer c : list)
		{
			if(c.getPassword().equals(userdto.getPassword()))
			{
				//Login success
				result = UserDTO.getDTOFromCustomer(c);
			}
		}
		 return result;
	}

	
	
	
}
