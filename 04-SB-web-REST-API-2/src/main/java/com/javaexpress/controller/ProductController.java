package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entities.Product;
import com.javaexpress.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}
	
	@GetMapping("{pId}")
	public Product fetchProduct(@PathVariable(name = "pId") Long productId) {
		return productService.fetchProductInfo(productId);
	}
}
