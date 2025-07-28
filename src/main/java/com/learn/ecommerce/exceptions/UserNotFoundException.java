package com.learn.ecommerce.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
