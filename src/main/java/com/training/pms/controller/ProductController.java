package com.training.pms.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
	@GetMapping
	public String getProducts() {		//localhost:5050/product	-GET
		return "Getting all the products";
	}
	@GetMapping("single")
	public String getProduct() {		//localhost:5050/product/single		-GET
		return "Getting a single product";
	}
	@PostMapping
	public String saveProduct() {		//localhost:5050/product		-POST
		return "Saving a single product";
	}
	@PutMapping
	public String updateProduct() {		//localhost:5050/product		-PUT
		return "Updating a single product";
	}
	@DeleteMapping
	public String deleteProduct() {		//localhost:5050/product		-DELETE
		return "Deleting a single product";
	}	
	@DeleteMapping("/allProduct")
	public String deleteProduct2() {		//localhost:5050/product/allProduct		-DELETE
		return "Deleting all the products";
	}
}
