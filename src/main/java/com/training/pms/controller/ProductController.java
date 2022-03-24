package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Product;
import com.training.pms.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProducts() {		//localhost:5050/product	-GET
		return productService.getProducts();
		//return "Getting all the products";
	}
	
	
	@PostMapping
	public String saveProduct(@RequestBody Product product) {		//localhost:5050/product		-POST
		return productService.addProduct(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("{productId}")
	public String getProduct(@PathVariable("productId")int productId)//localhost:5050/product/89		-GET
	{
		//code here to fetch product by id
		return "Getting a single product by productId : "+productId;
	}
	
	@GetMapping("searchProductByName/{productName}")
	public String getProductByProductName(@PathVariable("productName")String pname) {	//localhost:5050/product/Bottle	-GET
		return "Getting a single product by productName "+pname;
	}
	
	
	@GetMapping("filterProductByPrice/{lowerPrice}/{upperPrice}")
	public String filterProductByPrice(@PathVariable("lowerPrice")int lowerPrice,@PathVariable("upperPrice")int upperPrice) {	//localhost:5050/product/Bottle	-GET
		return "Returning all the products between :"+lowerPrice+ " and " +upperPrice;
	}
	
	@DeleteMapping
	public String deleteProduct() {		//localhost:5050/product		-DELETE
		return "Deleting a single product";
	}	
	
	@DeleteMapping("{productId}")
	public String deleteProductById(@PathVariable("productId") int productId) {
		return "Deleting a single product by id: "+productId;
	}

	
	@DeleteMapping("/allProduct")
	public String deleteProduct2() {		//localhost:5050/product/allProduct		-DELETE
		return "Deleting all the products";
	}
	
	
	@DeleteMapping("deleteProductByName/{productName}")
	public String deleteProductName(@PathVariable("productName")String productName) { //localhost:5050/productName   -DELETE
		return "Delete a product by its name : " + productName ;
	}

	

	@PutMapping("{productId}")
	public String updateProduct(@PathVariable("productId")int productId, 
			@RequestBody Product product) {		//localhost:5050/product/19189		-PUT
		return "Updating a single product with "+productId+ " and the changes are :"+product;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
