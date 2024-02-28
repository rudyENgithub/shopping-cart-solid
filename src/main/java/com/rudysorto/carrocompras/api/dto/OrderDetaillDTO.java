package com.rudysorto.carrocompras.api.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data of Orderdetail in presentation layer
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetaillDTO  {


	private String id;
	
	private int quantity;
	
	private double price;
	
	private ProductDTO product;

}
