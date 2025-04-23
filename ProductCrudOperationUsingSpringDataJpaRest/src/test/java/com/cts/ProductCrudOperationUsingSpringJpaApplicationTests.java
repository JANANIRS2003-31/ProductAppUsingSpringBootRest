package com.cts;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
//import com.cts.repository.ProductRepositoryImpl;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudOperationUsingSpringJpaApplicationTests {
	@Mock
	ProductRepository repository;
	
	@InjectMocks
	ProductServiceImpl service;
	
	@Test
	void saveProductTest() {
		Product product = new Product("Samsung",23000,"Mobile",5);
		Mockito.when(repository.save(product)).thenReturn(product);
		String response = service.saveProduct(product);
		
		assertEquals("Product Saved Successfully",response);
	}

}
