package com.rudysorto.carrocompras.api.dto;

import java.util.Date;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rudysorto.carrocompras.api.dto.OrderDTO;
import com.rudysorto.carrocompras.api.dto.PaymentDTO;

import lombok.Data;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data of Payment entity in presentation layer
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO 
{
	
	private int id;
	
	private String method;
	
	private double amount;
	
	private OrderDTO order;
	
    @Type(type="date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date paymentdate;

}

