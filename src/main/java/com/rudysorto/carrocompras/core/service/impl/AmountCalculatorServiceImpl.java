package com.rudysorto.carrocompras.core.service.impl;



import org.springframework.stereotype.Service;

import com.rudysorto.carrocompras.api.dto.OrderDTO;
import com.rudysorto.carrocompras.api.dto.OrderDetaillDTO;
import com.rudysorto.carrocompras.core.service.CalculatorService;


/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Service used to define the method calculateTotalOrder used to calculate price per quantity 
*/
@Service
public class AmountCalculatorServiceImpl implements CalculatorService<OrderDTO> {


	@Override
	public double calculateTotalOrder(OrderDTO orden) {
		double mount = 0;
		
		for (OrderDetaillDTO item :orden.getItems()) {
			mount = mount + (item.getQuantity() * item.getPrice());
			
			
		}
		return mount;
	}
}
