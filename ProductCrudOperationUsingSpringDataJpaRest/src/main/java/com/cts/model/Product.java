package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "products_info")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id

	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message = "ProductName can't be NULL or BLANK")
	@NotNull // ensures that a field is not null
	@NotEmpty // checks that a field is not null and not empty
	private String productName;
	@Column(name = "price")
	@Min(value = 100, message = "ProductPrice must be above 100") // Validates that a numeric value is greater than or
																	// equal to the specified value
	@Max(value = 100000, message = "ProductPrice must be below 1 lakh") // Validates that a numeric value is less than
																		// or equal to the specified value
	private int productPrice;
	@Size(min = 5, max = 12, message = "Category length must be between (5,12) ")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message = "Quantity cannot be Zero or negative")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}
}
