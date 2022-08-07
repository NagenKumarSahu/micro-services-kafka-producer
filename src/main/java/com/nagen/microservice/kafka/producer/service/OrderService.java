package com.nagen.microservice.kafka.producer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagen.microservice.kafka.producer.entity.Order;
import com.nagen.microservice.kafka.producer.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka.topic-name}")
	private String topicName;

	public Order saveOrder(Order order) throws JsonProcessingException {
		order = orderRepository.save(order);
		ObjectMapper objectMapper = new ObjectMapper();
		String ordeData = objectMapper.writeValueAsString(order);

		kafkaTemplate.send(topicName, ordeData);
		return order;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderDetails(Long orderId) {
		Order order = null;
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if (orderOptional.isPresent()) {
			order = orderOptional.get();
		}
		return order;
	}

}
