package com.rudysorto.carrocompras.testing.controller.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rudysorto.carrocompras.api.controller.OrderController;
import com.rudysorto.carrocompras.core.service.IOrderService;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IOrderService service;
	
	
	

}
