package com.rudysorto.carrocompras.core.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rudysorto.carrocompras.api.dto.PaymentDTO;
import com.rudysorto.carrocompras.core.service.CalculatorService;
import com.rudysorto.carrocompras.core.service.IPaymentService;
import com.rudysorto.carrocompras.database.dao.IOrderDAO;
import com.rudysorto.carrocompras.database.dao.IPaymentDAO;
import com.rudysorto.carrocompras.database.domain.Order;
import com.rudysorto.carrocompras.database.domain.Payment;
import com.rudysorto.carrocompras.exception.FieldMustExistException;
import com.rudysorto.carrocompras.exception.FieldNotNullException;
import com.rudysorto.carrocompras.exception.NotFoundException;



@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	IPaymentDAO repository;
	

	@Autowired
	IOrderDAO orderRepository;
	
	@Autowired
	CalculatorService calculator;
	
	@Autowired
	ModelMapper modelMapper;

	
	@Override
	@Transactional(readOnly = true)
	public List<PaymentDTO> getAll() 
	{
		List<Payment> payments = repository.findAll();
		List<PaymentDTO> paymentsdto = payments.stream().map( payment -> modelMapper.map(payment, PaymentDTO.class) ).collect(Collectors.toList());


		if (payments.isEmpty())
			throw new NotFoundException("No Payments found");

		return paymentsdto;
	}

	@Override
	@Transactional
	public PaymentDTO create(PaymentDTO entity)
	{
		if (entity.getOrder() == null) {
            throw new FieldNotNullException("Order cannot be null");

        }
		if ( orderRepository.findById(entity.getOrder().getId()).isEmpty() ) {
            throw new FieldMustExistException("Order must exist in the database");

        }
	
		entity.setAmount(calculator.calculateTotalOrder(entity.getOrder()));
		Payment payment = modelMapper.map(entity, Payment.class);

        return modelMapper.map(repository.save(payment), PaymentDTO.class);
	}


	@Override
	public PaymentDTO save(PaymentDTO entity) {
		
		Payment payment = modelMapper.map(entity, Payment.class);

        return modelMapper.map(repository.save(payment), PaymentDTO.class);
	}
	
	

}
