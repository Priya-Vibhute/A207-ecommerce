package com.learn.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ecommerce.UserDto;
import com.learn.ecommerce.entities.User;
import com.learn.ecommerce.exceptions.UserNotFoundException;
import com.learn.ecommerce.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {
		
		User savedUser = userRepository.save(dtoToEntity(userDto));
		
		return entityToDto(savedUser);
	}

	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		
		User user = userRepository.findById(id)
		.orElseThrow(()->new UserNotFoundException("User not found"));
		
		
		userDto.setId(id);
		User savedUser = userRepository.save(dtoToEntity(userDto));
		
		
		return entityToDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
	
		return userRepository.findAll().stream()
				.map(u->entityToDto(u)).toList();
	}

	@Override
	public UserDto getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		User user = userRepository.findByEmail(email)
		.orElseThrow(()->new UserNotFoundException("User not found"));
		return entityToDto(user);
	}

	@Override
	public List<UserDto> getUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstName(firstName)
				.stream().map(u->entityToDto(u)).toList();
	}

	@Override
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAge(user.getAge());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAddress(user.getAddress());
		return userDto;
	}

	@Override
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAge(userDto.getAge());
		user.setAddress(userDto.getAddress());
		return user;
	}

}
