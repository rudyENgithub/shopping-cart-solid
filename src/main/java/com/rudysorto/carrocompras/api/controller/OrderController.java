package com.rudysorto.carrocompras.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudysorto.carrocompras.api.dto.OrderDTO;
import com.rudysorto.carrocompras.core.service.IOrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to expose a restful api to access order information
Way to use it: expose via http the server+port+ requestmapping + getmapping in this case http://localhost:8489/api/orders
*/
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
@Tag(name = "Orders", description = "Order API")
public class OrderController {

	@Autowired
	IOrderService service;

	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com Objective: respond with orders if
	 * any Way to use it: you can get the orders by making an http request GET
	 * http://localhost:8489/api/orders
	 */
	@GetMapping("/orders")
	@Operation(summary = "Get All Orders", description = "Get All Orders", tags = { "Orders" })
	public ResponseEntity<List<OrderDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com 
	 * Objective: respond with a specific order if there is any 
	 * Way to use it: you can get the order by making an http request GET http://localhost:8489/api/orders/1
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@Operation(summary = "Get Order By Id", description = "Get Order By Id", tags = { "Orders" })
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDTO> getById(@Parameter(description = "Order Id") @PathVariable int id) {
		return ResponseEntity.ok(service.get(id));
	}
	
	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com 
	 * Objective: method to save an order in the database
	 * Way to use it: you can save the order by making an http request POST http://localhost:8489/api/orders with OrderDTO method to save an order in the database with an OrderDTO in the request body
	 */
	@Secured("ROLE_ADMIN")
	@Operation(summary = "Add Order", description = "Add Order", tags = { "Orders" })
	@PostMapping("/orders")
	public ResponseEntity<OrderDTO> addOrder(
			@Parameter(description = "Order", required = true) @RequestBody OrderDTO orderDto) {
		return ResponseEntity.ok(service.create(orderDto));
	}
	
	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com 
	 * Objective: method to update an order in the database
	 * Way to use it: you can update the order by making an http request PUT http://localhost:8489/api/orders/{id} with OrderDTO in the request body
	 */
	@Secured("ROLE_ADMIN")
	@Operation(summary = "Update Order", description = "Update Order", tags = { "Orders" })
	@PutMapping("/orders/{id}") 
	public ResponseEntity<OrderDTO> updateOrder(@Parameter(description = "Order Id") @PathVariable int id,
			@Parameter(description = "Order") @RequestBody OrderDTO orderDto) 
	{
		return ResponseEntity.ok(service.save(id, orderDto));
	}

	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com 
	 * Objective: method to delete an order in the database
	 * Way to use it: you can delete the order by making an http request DELETE http://localhost:8489/api/orders/{id}
	 */
	@Secured("ROLE_ADMIN")
	@Operation(summary = "Delete Order", description = "Delete Order", tags = { "Orders" })
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<OrderDTO> deleteProduct(@Parameter(description = "Order Id") @PathVariable int id) {
		
		return ResponseEntity.ok(service.delete(id));
	}

	

}
