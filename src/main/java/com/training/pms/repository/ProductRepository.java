package com.training.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.pms.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByProductName(String productName);

	List<Product> findByPriceBetween(int lowerPrice, int upperPrice);

	List<Product> findByQuantityOnHandBetween(int lowerBound, int upperBound);

	@Query("SELECT COUNT(*) FROM Product p")
	public int countProducts();

	@Query("FROM Product p WHERE p.productName LIKE :pname")
	public Optional<List<Product>> findByMyProductName(@Param("pname") String productName);
	
	//WAQ method that should return all the products based on price and qoh
	//price = 90
	//qoh > 10
	//??
	@Query("From Product p WHERE p.price = :price and p.quantityOnHand > :lowerBoundQOH")
	public Optional<List<Product>> findByMyPriceAndQuantityOnHand(@Param("price")int price,@Param("lowerBoundQOH")int lowerBoundQOH );


}
