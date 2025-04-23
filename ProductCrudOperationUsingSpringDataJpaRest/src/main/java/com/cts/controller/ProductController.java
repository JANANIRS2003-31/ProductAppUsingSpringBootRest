package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // http://localhost:1111/products/getMsg
	public String sayHello() {
		return "am need break but trying to listen also am getting sleep";
	}

	@PostMapping("/saveproduct") // http://localhost:1111/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:1111/products/updateproduct
	public Product updateProduct(@RequestBody @Validated Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/getproduct/{pid}") // http://localhost:1111/products/getproduct/1
	public Product getProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}

	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1111/products/deleteproduct/302
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}

	@GetMapping("/getallproduct") // http://localhost:1111/products/getallproduct
	public List<Product> getAllProduct() {
		return service.getAllProducts();
	}

	@GetMapping("/getallproductsbetween/{price1}/{price2}") // http://localhost:1111/products/getallproductsbetween
	public List<Product> getAllProductsBetween(@PathVariable("price1") int initialPrice,@PathVariable("price2") int finalPrice) {
		return service.getAllProductsBetween(initialPrice,finalPrice);
	}
	
	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1111/products/getallproductsbycategory/eletronics
	public List<Product> getAllProductsByCategory(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
}