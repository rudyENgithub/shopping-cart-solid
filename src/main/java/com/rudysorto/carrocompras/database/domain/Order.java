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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to map the orders table in the database to java objects
*/
@Entity
@Table(name="orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnoreProperties(value={"orders", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@JsonIgnoreProperties(value={"orders", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column
    @Type(type="date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderdate;
	
	@Column
    @Type(type="date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date shippingdate;
	
	private String state;
	
	private String comments;
	
	@JsonIgnoreProperties(value={"order", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	//@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> items;
	
	@JsonIgnoreProperties(value={"order", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	//@ToString.Exclude
	@OneToOne(mappedBy = "order")
    private Payment payment;
	
	
	
	
	

}
