package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("userbyid")
    public User findUser(@Nullable @RequestParam int user_id){

        return userService.findUser(user_id);
    }


}
