package com.rudysorto.carrocompras.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudysorto.carrocompras.api.dto.OrderDTO;
import com.rudysorto.carrocompras.api.dto.PaymentDTO;
import com.rudysorto.carrocompras.core.service.IPaymentService;
import com.rudysorto.carrocompras.database.domain.Payment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to expose a restful api to access payment information
Way to use it: expose via http the server+port+ requestmapping + getmapping in this case http://localhost:8489/api/payments
*/
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	IPaymentService service;
	
	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com Objective: respond with orders if
	 * any Way to use it: you can get the payments by making an http request GET
	 * http://localhost:8489/api/payments
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/payments")
	@Operation(summary = "Get All Payments", description = "Get All Payments", tags = { "Payments" })
	public ResponseEntity<List<PaymentDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com 
	 * Objective: method to save an payment in the database
	 * Way to use it: you can save the order by making an http request POST http://localhost:8489/api/orders with OrderDTO method to save an payment in the database with an OrderDTO in the request body
	 */
	@Secured("ROLE_ADMIN")
	@Operation(summary = "Add Payment", description = "Add Payment", tags = { "Payments" })
	@PostMapping("/payments")
	public ResponseEntity<PaymentDTO> addOrder(
			@Parameter(description = "Payment", required = true) @RequestBody PaymentDTO paymentDto) 
	{
		return ResponseEntity.ok(service.create(paymentDto));
	}

}
