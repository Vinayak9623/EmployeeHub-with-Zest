package com.employeeHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeHub.entity.User;
import com.employeeHub.jwtSecurity.JwtUtil;
import com.employeeHub.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user) {

		User registerUser = userService.registerUser(user);

		return ResponseEntity.ok("Regestred sucessfully" + registerUser.getUsername());
	}
	
	
	

	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		Authentication authentication = authenticationManager
		.authenticate
		(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtUtil.genrateToken(userDetails.getUsername());

		return ResponseEntity.ok(token);
	}
}
