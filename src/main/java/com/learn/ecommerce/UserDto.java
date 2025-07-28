package com.learn.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.ecommerce.validators.PasswordMatch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserDto {
	
	private String id;

	private String firstName;

	private String lastName;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$")
	private String password;
	
	private String confirmPassword;
	@Min(5)
	@Max(70)
	private int age;
	private String email;
	
	

}
