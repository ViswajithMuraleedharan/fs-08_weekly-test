package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.OrderRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order findOrder(int order_id){
        return orderRepository.getReferenceById(order_id);
    }
}
