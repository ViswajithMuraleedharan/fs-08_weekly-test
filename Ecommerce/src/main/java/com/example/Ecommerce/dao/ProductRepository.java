package com.example.Ecommerce.dao;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
