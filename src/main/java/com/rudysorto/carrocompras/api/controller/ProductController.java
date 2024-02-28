package com.rudysorto.carrocompras.api.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rudysorto.carrocompras.api.dto.ProductDTO;
import com.rudysorto.carrocompras.core.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;


/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to expose a restful api to access product information
Way to use it: expose via http the server+port+ requestmapping + getmapping in this case http://localhost:8489/api/products
*/
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	IProductService service;
	

	@Autowired
	ModelMapper modelMapper;

	
	/*
	 Author: Rudy Sorto rudy.eli.ayala@gmail.com
	 Objective: respond with products if any
	 Way to use it: you can get the products by making an http request GET http://localhost:8489/api/products
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/products/populate")
	@Operation(summary = "Get All Products", description = "Get All Products", tags = { "Products" })
	public ResponseEntity<List<ProductDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

}
