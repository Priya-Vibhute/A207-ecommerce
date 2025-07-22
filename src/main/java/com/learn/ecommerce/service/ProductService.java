package com.learn.ecommerce.service;

import java.util.List;

import com.learn.ecommerce.entities.Product;

public interface ProductService {
	
   Product	addProduct(Product product);
   
   Product getById(int id);
   
   Product updateProduct(int id,Product product);
   
   List<Product> allProducts();
   
   void deleteById(int id);

}
