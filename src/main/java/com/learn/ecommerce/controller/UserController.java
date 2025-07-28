package com.learn.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ecommerce.UserDto;
import com.learn.ecommerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto)
	{
		return new ResponseEntity<UserDto>(userService.addUser(userDto),
				                 HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String id,
			                                             @RequestBody @Valid UserDto userDto)
	{
		return ResponseEntity.ok(userService.updateUser(id, userDto));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
	{
		return new ResponseEntity<UserDto>(userService.getUserByEmail(email),
				HttpStatus.FOUND);
	}

}
