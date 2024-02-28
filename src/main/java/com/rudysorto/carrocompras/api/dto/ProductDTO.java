package com.rudysorto.carrocompras.api.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data of Product entity in presentation layer
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO
{

	
	private int id;
	private String title;
	private int price;
	private String category;
	private String description;
	private String image;
	
	
	

}
