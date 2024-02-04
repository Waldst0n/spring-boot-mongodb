package com.waldstonsantana.mongodbspringboot.services;

import com.waldstonsantana.mongodbspringboot.models.UserModel;
import com.waldstonsantana.mongodbspringboot.repositories.UserRepository;
import com.waldstonsantana.mongodbspringboot.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(String id) {
        UserModel user = userRepository.findById(id).get();
        if (user == null)  {
            throw new NotFoundException("Objeto não encontrado!");
        }
        return user;
    }
}
