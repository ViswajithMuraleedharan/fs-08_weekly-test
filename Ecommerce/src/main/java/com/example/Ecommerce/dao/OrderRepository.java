package com.example.Ecommerce.dao;

import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Integer> {
}
