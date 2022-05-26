package com.ekart.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.users.dto.UserDTO;
import com.ekart.users.entity.Seller;
import com.ekart.users.repository.SellRepo;

@Service
public class SellService {
	
	@Autowired
	SellRepo sellRepo;
	
	
	
	public void register(UserDTO userdto) {
		sellRepo.saveAndFlush(userdto.getSellerEntity());
	}

	
	
	
	public UserDTO login(UserDTO userdto) {
//		System.out.println("1.1");
		List<Seller> list = sellRepo.findByUsername(userdto.getUsername());
//		System.out.println("1.2");
		UserDTO result = null;
//		System.out.println("1.3");
		for(Seller c : list)
		{
			if(c.getPassword().equals(userdto.getPassword()))
			{
				//Login success
				result = UserDTO.getDTOFromSeller(c);
			}
		}
//		System.out.println("1.4");
		 return result;
	}
	
	
	
	

}
