package com.nagen.microservice.kafka.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagen.microservice.kafka.producer.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
