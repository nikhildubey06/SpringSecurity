package com.springsecuritydatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritydatabase.model.User;
import com.springsecuritydatabase.repository.UserRepository;

@RestController
@RequestMapping("/secure/auth")
public class AdminController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/admin/addUser")
	public String addUser(@RequestBody User user) {
		
		String pwd=user.getPassword();
		String encryptedpwd=passwordEncoder.encode(pwd);
		user.setPassword(encryptedpwd);
		userRepository.save(user);
		return "User Added Successfully !!!";
		
	}

}
