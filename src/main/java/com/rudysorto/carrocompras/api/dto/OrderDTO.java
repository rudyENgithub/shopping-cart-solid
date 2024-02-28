package com.rudysorto.carrocompras.api.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data of Order entity in presentation layer
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

	private int id;
	
	private CustomerDTO customer;
	
	private UserDTO user;
	
	private String shippingdate;
	
	private String orderdate;
	
	private String state;
	
	private String comments;
	
	private List<OrderDetaillDTO> items;
	
	



}
