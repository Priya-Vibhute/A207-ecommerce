package com.learn.ecommerce.service;

import java.util.List;

import com.learn.ecommerce.UserDto;
import com.learn.ecommerce.entities.User;

public interface UserService {
	
	UserDto addUser(UserDto userDto);
	
	UserDto updateUser(String id,UserDto userDto);
	
    List<UserDto> getAllUsers();
    
    UserDto  getUserById(String id);
    
    UserDto getUserByEmail(String email);
    
    List<UserDto> getUserByFirstName(String firstName);
    
    UserDto entityToDto(User user);
    
    User dtoToEntity(UserDto userDto);
   
   

}
