package com.learn.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.learn.ecommerce.entities.Product;
import com.learn.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
    @Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> fetchProducts()
	{
		return ResponseEntity.ok(productService.allProducts());
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id)
	{
		return new ResponseEntity<Product>(productService.getById(id),HttpStatus.FOUND);
	}
	
   @PutMapping("/{id}")
   public ResponseEntity<Product> updateProduct(@PathVariable int id,
		   @RequestBody Product product)
   {
	  return ResponseEntity.ok(productService.updateProduct(id, product));
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Product> deleteProduct( @PathVariable int id)
   {
	   Product product = productService.getById(id);
	   productService.deleteById(id);
	   return ResponseEntity.ok(product);
   }
	
	
	
	
	
}
