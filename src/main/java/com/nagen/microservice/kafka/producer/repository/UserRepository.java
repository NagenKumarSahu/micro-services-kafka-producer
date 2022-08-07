package com.nagen.microservice.kafka.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagen.microservice.kafka.producer.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
