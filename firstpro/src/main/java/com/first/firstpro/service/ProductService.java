package com.first.firstpro.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.first.firstpro.model.Product;
import com.first.firstpro.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	public List<Product> getProducts(){
		return repo.findAll();
	}
	
	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	 public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
	        product.setImageName(imageFile.getOriginalFilename());
	        product.setImageType(imageFile.getContentType());
	        product.setImageData(imageFile.getBytes());

	        return repo.save(product);
	    }

	public Product updateProduct(int id, Product product, MultipartFile imageFile)throws IOException {
		product.setImageData(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		 repo.deleteById(id);
	}

	public List<Product> searchProducts(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchProducts(keyword);
	}
}
