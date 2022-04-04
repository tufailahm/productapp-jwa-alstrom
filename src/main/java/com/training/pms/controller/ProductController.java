package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.training.pms.utility.Demo;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	Demo demo;

	// Hands on 200 if record is there else 204 if no records are there
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> result = productService.getProducts();
		ResponseEntity<List<Product>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}
		return responseEntity;
	}

	// save
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) { // localhost:5050/product -POST

		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productService.isProductExists(product.getProductId())) {
			result = "Product with product id :" + product.getProductId() + " already exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK); // 200
		} else {
			result = productService.addProduct(product);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);// 201
		}
		return responseEntity;
	}
	//update
	@PutMapping("{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) { // localhost:5050/product/19189

		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productService.isProductExists(product.getProductId())) {
			result = productService.updateProduct(productId, product);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);// 200
		} else {
			result = "Product with product id :" + product.getProductId() + " does not exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED); // 304
		}
		return responseEntity;
	}
	//get product by id
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId)// localhost:5050/product/89 -GET
	{
		ResponseEntity<Product> responseEntity = null;
		Product product = new Product();
		if (productService.isProductExists(productId)) {
			product = productService.getProduct(productId);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);// 200
		} else {
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT); // 204
		}
		return responseEntity;
	}

	
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteByProductId(@PathVariable("productId")int productId) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productService.isProductExists(productId)) {
			result = productService.deleteProduct(productId);
			responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
		} else {
			result = "Product (id:"+productId+") does not exist";
			responseEntity = new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	
	
	
	


	@DeleteMapping
	public String deleteProduct() { // localhost:5050/product -DELETE
		return "Deleting a single product";
	}



	@DeleteMapping("/allProduct")
	public String deleteProduct2() { // localhost:5050/product/allProduct -DELETE
		return "Deleting all the products";
	}

	@DeleteMapping("deleteProductByName/{productName}")
	public String deleteProductName(@PathVariable("productName") String productName) { // localhost:5050/productName
																						// -DELETE
		return "Delete a product by its name : " + productName;
	}

	//localhost:5050/product/searchProductByName/Lakme
	@GetMapping("searchProductByName/{productName}")
	public ResponseEntity<List<Product>> getProductByProductName(@PathVariable("productName") String pname) { // localhost:5050/product/Bottle
		List<Product> result = productService.getProductByName(pname);
		ResponseEntity<List<Product>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	//localhost:5050/product/filterProductByPrice/100/200
	@GetMapping("filterProductByPrice/{lowerPrice}/{upperPrice}")
	public ResponseEntity<List<Product>> filterProductByPrice(@PathVariable("lowerPrice") int lowerPrice,
			@PathVariable("upperPrice") int upperPrice) { // localhost:5050/product/Bottle -GET
		List<Product> result = productService.getProductByPriceRange(lowerPrice,upperPrice);
		ResponseEntity<List<Product>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}
		return responseEntity;
	}

}
