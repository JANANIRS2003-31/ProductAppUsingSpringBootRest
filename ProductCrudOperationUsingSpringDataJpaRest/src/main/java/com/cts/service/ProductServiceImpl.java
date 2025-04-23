package com.cts.service;

import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
//import com.cts.repository.ProductRepositoryImpl;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository repository;

	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method ....");
		Product pro = repository.save(product);
		if(pro != null) {
			 return "Product Saved successfully";
		}
		else {
			return "No product is saved";
		}
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro = repository.save(product);
		return pro;
		}
	

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted Succesfully";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		Optional<Product> optional =  repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product Id is not availale....");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repository.findByProductCategoryIs(category);
	}
	
	@Override
	public List<Product> getAllProductsGreater(int Price) {
		return repository.findByProductPriceGreaterThan(Price);
	}
}
