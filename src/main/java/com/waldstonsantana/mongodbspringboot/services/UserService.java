package com.waldstonsantana.mongodbspringboot.services;

import com.waldstonsantana.mongodbspringboot.models.UserModel;
import com.waldstonsantana.mongodbspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
}
