package com.learn.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
//@Table(name = "product_details")
public class Product {
	
	@Id
	private int id;
	
	@Column(nullable = false,length = 50)
	private String name;
	
	@Column(nullable = false,length = 200)
	private String description;
	
	private int price;

}
