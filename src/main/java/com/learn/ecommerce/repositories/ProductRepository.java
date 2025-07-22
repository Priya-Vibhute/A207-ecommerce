package com.learn.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.ecommerce.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findBypriceLessThan(int price);
	
}
