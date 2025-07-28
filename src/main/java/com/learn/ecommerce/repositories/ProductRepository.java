package com.learn.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.learn.ecommerce.entities.Product;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findBypriceLessThan(int price);
	List<Product> findBypriceGreaterThan(int price);
	List<Product> findBypriceBetween(int startPrice,int endPrice);
	List<Product> findByOrderByPrice(); 
	List<Product> findByOrderByPriceDesc(); 


	
}
