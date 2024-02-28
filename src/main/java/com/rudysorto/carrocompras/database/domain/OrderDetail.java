package com.rudysorto.carrocompras.database.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to map the ordersdetail table in the database to java objects
*/
@Entity
@Table(name="ordersdetail")
@Data
@NoArgsConstructor
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties(value={"items", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	private int quantity;
	
	private double price;
	
	@JsonIgnoreProperties(value={"items", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

}
