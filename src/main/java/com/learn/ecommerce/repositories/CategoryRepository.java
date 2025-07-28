package com.learn.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	 List<Category> findByName(String name);
	 List<Category> findByNameContaining(String keyword);

}
