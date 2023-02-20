package com.example.Ecommerce.controller;

import com.example.Ecommerce.dao.ProductRepository;
import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.OrderService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("orderbyid")
    public Order findOrder(@Nullable @RequestParam Integer order_id){
        return orderService.findOrder(order_id);
    }


}
