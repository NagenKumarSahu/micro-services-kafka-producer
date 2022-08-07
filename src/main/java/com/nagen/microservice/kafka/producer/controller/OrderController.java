package com.nagen.microservice.kafka.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagen.microservice.kafka.producer.entity.Order;
import com.nagen.microservice.kafka.producer.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	public Order saveOrder(@RequestBody Order order) throws JsonProcessingException {
		return orderService.saveOrder(order);
	}

	@GetMapping("/")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public Order getOrderDetails(@PathVariable("orderId") Long orderId) {
		return orderService.getOrderDetails(orderId);
	}

}
