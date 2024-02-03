package com.waldstonsantana.mongodbspringboot.config;

import com.waldstonsantana.mongodbspringboot.models.UserModel;
import com.waldstonsantana.mongodbspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        UserModel maria = new UserModel(null, "Maria Brown", "maria@gmail.com");
        UserModel alex = new UserModel(null, "Alex Green", "alex@gmail.com");
        UserModel bob = new UserModel(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));




    }
}
