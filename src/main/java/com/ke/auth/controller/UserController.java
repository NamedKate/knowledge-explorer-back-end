package com.ke.auth.controller;

import com.ke.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/user")
	public Principal user(Principal user){
		return user;
	}

}
