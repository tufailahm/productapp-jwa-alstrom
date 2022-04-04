package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.model.Product;
import com.training.pms.repository.ProductRepository;

@Service		//spring will create a bean and treats this as service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;		//??
	
	@Override
	@Transactional
	public String addProduct(Product product) {
		System.out.println("Adding products");
		if(product.getPrice() < 0  || product.getQuantityOnHand() < 0)
			return "Product could not be saved because either price or qoh is negative";
		else
		{
			productRepository.save(product);
			return "Product saved successfully!!";
		}
	}
	@Override
	@Transactional
	public String updateProduct(int productId, Product product) {
		if(product.getPrice() < 0  || product.getQuantityOnHand() < 0)
			return "Product could not be updated because either price or qoh is negative";
		else
		{
			productRepository.save(product);
			return "Product updated successfully!!";

		}
	}
	@Override
	public String deleteProduct(int productId) {
		 productRepository.deleteById(productId);
		 return "Product deleted successfully!!";
	}

	@Override
	public List<Product> getProducts() {
		System.out.println("Getting all products");

		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		Optional<Product> product =  productRepository.findById(productId);
		return product.get();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product =  productRepository.findById(productId);
		return product.isPresent();
	}

	@Override
	public String deleteProduct() {
		productRepository.deleteAll();
		return "Product deleted successfully!!";
	}

	
	
	
	@Override
	public int checkProductStock(int productid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<Product> getProductByPriceRange(int lowerPrice, int upperPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(lowerPrice, upperPrice);
	}

}
