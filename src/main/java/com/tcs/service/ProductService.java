package com.tcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.entity.Product;
import com.tcs.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository pr;

	public ProductService(ProductRepository pr) {
		super();
		this.pr = pr;
	}
	
	public Product addProduct(Product p) {
		 Product pp= pr.save(p);
		System.out.println(pp + " added successfully");
		return pp;
	}

	public List<Product> addAllProduct(List<Product> prdt) {
		return pr.saveAll(prdt);
	}

	public String getAllProducts() {
		List<Product> product= pr.findAll();
		
		for (Product pro2 : product) {
			System.out.println(pro2);
		}
		
		return "prdt are shown on console";
	}
	
	public Product updateProductbyId(Product NewPro,int id) {
		Product old= pr.findById(id).orElseThrow();
		
	    old.setName(NewPro.getName());
	    old.setPrice(NewPro.getPrice());
	    old.setCategory(NewPro.getCategory());
	    
	    Product ol= pr.save(old);  
	    System.out.println(ol);
	    return ol;
	}
	
	public String deleteProductById(int id) {
		pr.deleteById(id);
		return  "Product deleted successfully";
	}
}
