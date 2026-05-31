package com.tcs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.Product;
import com.tcs.service.ProductService;

@RestController
public class ProductController {

	private final ProductService ps;

	public ProductController(ProductService ps) {
		super();
		this.ps = ps;
	}

	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product p) {
		return ps.addProduct(p);	
	}
	
	@PostMapping("/add-all-products")
	public List<Product> addAllProducts(@RequestBody List<Product> prdt) {
		return ps.addAllProduct(prdt);
	}
	
	@GetMapping("/show-all-prdt") 
	public String getAllProduct() {
		return ps.getAllProducts();
	}
	
	@PostMapping("/update-by-id/{id}")
public Product updateProductbyId(@RequestBody Product NewPro,@PathVariable int id) {
	  return ps.updateProductbyId(NewPro, id);
	}
	
	@DeleteMapping("/delete-prdt-by-id/{id}")
	public String deleteProductById(@PathVariable int id) {
		return ps.deleteProductById(id);
	}
}
