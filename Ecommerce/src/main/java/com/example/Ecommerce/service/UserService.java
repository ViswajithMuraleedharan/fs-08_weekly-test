package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



    public User findUser(int user_id){
        return userRepository.getById(user_id);
    }
}
