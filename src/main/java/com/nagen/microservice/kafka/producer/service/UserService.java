package com.nagen.microservice.kafka.producer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagen.microservice.kafka.producer.entity.User;
import com.nagen.microservice.kafka.producer.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUserDetails(){
		return userRepository.findAll();
	}
	
	public User getUserDetails(Long userId) {
		User user = null;
		Optional<User> userOptional = userRepository.findById(userId);
		if(userOptional.isPresent()) {
			user = userOptional.get();
		}
		return user;
	}
}
