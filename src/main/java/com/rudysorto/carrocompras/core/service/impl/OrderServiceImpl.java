package com.rudysorto.carrocompras.core.service.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudysorto.carrocompras.api.dto.OrderDTO;

import com.rudysorto.carrocompras.core.service.IOrderService;
import com.rudysorto.carrocompras.database.dao.ICustomerDAO;
import com.rudysorto.carrocompras.database.dao.IOrderDAO;
import com.rudysorto.carrocompras.database.domain.Customer;
import com.rudysorto.carrocompras.database.domain.Order;
import com.rudysorto.carrocompras.database.domain.OrderDetail;
import com.rudysorto.carrocompras.exception.FieldMustExistException;
import com.rudysorto.carrocompras.exception.FieldNotNullException;
import com.rudysorto.carrocompras.exception.NotFoundException;
import com.rudysorto.carrocompras.util.ObjectMapperUtils;

import java.util.Optional;
import java.util.stream.Collectors;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: service used for the business logic of the orders
*/
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderDAO repository;
	
	@Autowired
	ICustomerDAO repositoryCustomer;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<OrderDTO> getAll() {
		List<Order> orders = this.repository.findAll();
		//List<OrderDTO> ordersdto = orders.stream().map(this::convertToDto).collect(Collectors.toList());
		List<OrderDTO> ordersdto = orders.stream().map( order -> modelMapper.map(order, OrderDTO.class) ).collect(Collectors.toList());


		if (orders.isEmpty())
			throw new NotFoundException("No Orders found");

		return ordersdto;

	}

	@Override
	@Transactional(readOnly = true)
	public OrderDTO get(int id) {
		Optional<Order> order = repository.findById(id);
		if (order.isEmpty())
			throw new NotFoundException("No order found with the given id");
		//return convertToDto(order.get());	
        return modelMapper.map(order.get(), OrderDTO.class);

	}

	@Override
	public OrderDTO create(OrderDTO entity) 
	{
		if (entity.getCustomer() == null) {
            throw new FieldNotNullException("Customer name cannot be null");

        }
		if ( repositoryCustomer.findById(entity.getCustomer().getId()).isEmpty() ) {
            throw new FieldMustExistException("Customer must exist in the database");

        }
		if (entity.getItems() == null) {
            throw new FieldNotNullException("Items cannot be null");

        }
		Order order = modelMapper.map(entity, Order.class);
		Customer customer = modelMapper.map(entity.getCustomer(), Customer.class);
		List<OrderDetail> items =  ObjectMapperUtils.mapAll(entity.getItems(), OrderDetail.class);
		order.setCustomer(customer);
		order.setItems(items);
        return modelMapper.map(repository.save(order), OrderDTO.class);
	}

	@Override
	public OrderDTO save(int id, OrderDTO entity) 
	{

			if ( repository.findById(id).isEmpty() ) {
	            throw new FieldMustExistException("Order must exist in the database");
	
	        }
	    	if (entity.getCustomer() == null) {
	            throw new FieldNotNullException("Customer name cannot be null");

	        }
			if ( repositoryCustomer.findById(entity.getCustomer().getId()).isEmpty() ) {
	            throw new FieldMustExistException("Customer must exist in the database");

	        }
			if (entity.getItems() == null) {
	            throw new FieldNotNullException("Items cannot be null");

	        }

			Optional<Order> order = repository.findById(id);
			Customer customer = modelMapper.map(entity.getCustomer(), Customer.class);
			List<OrderDetail> items =  ObjectMapperUtils.mapAll(entity.getItems(), OrderDetail.class);

			order.get().setComments(entity.getComments());
	        
	        return modelMapper.map(repository.save(order.get()), OrderDTO.class);
	}

	@Override
	public OrderDTO delete(int id) 
	{
		
		Order order = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Order found with the given id"));
		repository.deleteById(id);
        return modelMapper.map(order, OrderDTO.class);

	}
	

}
