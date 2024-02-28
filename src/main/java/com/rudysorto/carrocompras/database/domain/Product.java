package com.rudysorto.carrocompras.database.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to map the products table in the database to java objects
*/
@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private double price;
	
	private String category;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private String image;
	
	@JsonIgnoreProperties(value={"product", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> items;

}
