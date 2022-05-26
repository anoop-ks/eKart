package com.ekart.kart.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ekart.kart.dto.CartmapDTO;
import com.ekart.kart.dto.ProdDTO;
import com.ekart.kart.dto.ProductDTO;
import com.ekart.kart.dto.UserDTO;
import com.ekart.kart.service.ProductService;

@RestController
public class ProdController {
	
	@Autowired
	ProductService productService;
	@Autowired
	DiscoveryClient client;
	
	
	@GetMapping("/getprodview")
	public ResponseEntity<List<ProdDTO>> getview(){
		
		List<ProdDTO> result = productService.getprods();
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addprod")
	public void addprod(@RequestBody ProductDTO productDTO){
		
		productService.add(productDTO);
	}
	
	@GetMapping("/getdet/{id}")
	public ResponseEntity<ProductDTO> getdet(@PathVariable Long id)
	{
		return ResponseEntity.ok(productService.getdetails(id));
	}
	
	
	//------------------------------------------cart----------------------------------
	
	@PostMapping("/tocart")
	public void addtocart(@RequestBody CartmapDTO cartmapDTO) {
		productService.addtocart(cartmapDTO);
	}
	
	@HystrixCommand(fallbackMethod="loginFallback")
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDTO userdto)
	{
		List<ServiceInstance> instances=client.getInstances("user");
		ServiceInstance instance=instances.get(0);
		URI useruri = instance.getUri();
		
		System.out.println("Inside KART MS");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<UserDTO> request = 
			      new HttpEntity<UserDTO>(userdto, headers);
		 
		 
		UserDTO loginResult = new RestTemplate().postForObject(useruri+"/loginAsB",request , UserDTO.class);
		return ResponseEntity.ok(loginResult);
	}
}
