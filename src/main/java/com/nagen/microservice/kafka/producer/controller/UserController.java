package com.nagen.microservice.kafka.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagen.microservice.kafka.producer.entity.User;
import com.nagen.microservice.kafka.producer.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUserDetails(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{userId}")
	public User getUserDetails(@PathVariable("userId") Long userId) {
		return userService.getUserDetails(userId);
	}

	@GetMapping("/")
	public List<User> getAllUserDetails() {
		return userService.getAllUserDetails();
	}
}
