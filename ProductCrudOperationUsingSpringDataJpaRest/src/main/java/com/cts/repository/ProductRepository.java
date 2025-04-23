package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
//	public abstract String saveProduct(Product product);
//
//	public abstract String updateProduct(Product product);
//
//	public abstract String removeProduct(int productId);
//
//	public abstract Product getProduct(int productId);
//
//	public abstract List<Product> getAllProducts();

	public abstract List<Product> findByProductPriceGreaterThan(int price);
	
	public abstract List<Product> findByProductPriceBetween(int initialPrice, int finalPrice);

	public abstract List<Product> findByProductCategoryIs(String category);
}
