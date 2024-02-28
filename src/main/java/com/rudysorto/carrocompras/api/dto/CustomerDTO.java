package com.rudysorto.carrocompras.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data of Customer Entity in presentation layer 
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
	
	private int id;
	private String name;

}
