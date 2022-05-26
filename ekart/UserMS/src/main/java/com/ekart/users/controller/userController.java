package com.ekart.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.users.dto.UserDTO;
import com.ekart.users.service.CustService;
import com.ekart.users.service.SellService;

@RestController
public class userController {
	
	@Autowired
	CustService custService;
	
	@Autowired
	SellService sellService;
	
	//-------------------------------------------------------------------------------------Registration-------------------------------
	@PostMapping("/registerAsB")
	public void registerAsBuyer(@RequestBody UserDTO userdto) {
//		System.out.println("Inside Buyer Registration.....");
		custService.register(userdto);
	}
	
	@PostMapping("/registerAsS")
	public void registerAsSeller(@RequestBody UserDTO userdto) {
		sellService.register(userdto);
	}
	
	
	//-------------------------------------------------------------------------------------Login-------------------------------
	@PostMapping("/loginAsB")
	public ResponseEntity<UserDTO> loginAsBuyer(@RequestBody UserDTO userdto) {
		System.out.println("Inside USER MS");
		UserDTO result = custService.login(userdto);
		
		if(result == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		else
			return ResponseEntity.ok(result);
		
	}
	
	
	@PostMapping("/loginAsS")
	public ResponseEntity<UserDTO> loginAsSeller(@RequestBody UserDTO userdto) {
//		System.out.println("1");
		
		UserDTO result = sellService.login(userdto);
//		System.out.println("2");
		
		if(result == null)
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		else
			return ResponseEntity.ok(result);
	}
	
	
	//-------------------------------------------------------------------------------------Customer-------------
	
}