package com.learn.ecommerce.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ecommerce.entities.Product;
import com.learn.ecommerce.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(int id) {
		Product product = productRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		return product;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product fetchedProduct = productRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		fetchedProduct.setName(product.getName());
		fetchedProduct.setDescription(product.getDescription());
		fetchedProduct.setPrice(product.getPrice());
		
		Product updatedProduct = productRepository.save(fetchedProduct);	
		
		return updatedProduct;
	}

	@Override
	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
        Product product = productRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Id not found"));
        
        productRepository.delete(product);
	}

}
