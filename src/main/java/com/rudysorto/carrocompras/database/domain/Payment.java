package com.rudysorto.carrocompras.database.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to map the payments table in the database to java objects
*/
@Entity
@Table(name="payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String method;
	
	private double amount;
	@Column
    @Type(type="date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date paymentdate;
	

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	
	

}
