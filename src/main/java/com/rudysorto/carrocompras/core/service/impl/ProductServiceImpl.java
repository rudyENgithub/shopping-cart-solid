package com.rudysorto.carrocompras.core.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.rudysorto.carrocompras.api.dto.ProductDTO;

import com.rudysorto.carrocompras.core.service.IProductService;
import com.rudysorto.carrocompras.database.dao.IProductDAO;
import com.rudysorto.carrocompras.database.domain.Product;
import com.rudysorto.carrocompras.exception.NotFoundException;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: service used for the business logic of the products
*/
@Service
public class ProductServiceImpl implements IProductService {

	private final RestTemplate restTemplate;
	
	@Autowired
	IProductDAO repository;
	
	@Autowired
	ModelMapper modelMapper;

	public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Transactional
	public List<ProductDTO> getAll() {
		List<ProductDTO> productlst = new ArrayList<>();
		ProductDTO[] productdtolst = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDTO[].class);

			if (productdtolst.length == 0)
				throw new NotFoundException("No Products found");

				for (ProductDTO dto : productdtolst) {
					Product product = modelMapper.map(dto, Product.class);
					repository.save(product);
					productlst.add(dto);

				}

		return productlst;
	}
	

}
