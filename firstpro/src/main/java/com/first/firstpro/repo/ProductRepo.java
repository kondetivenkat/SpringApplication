package com.first.firstpro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.firstpro.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}
