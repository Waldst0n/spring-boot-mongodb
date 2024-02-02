package com.waldstonsantana.mongodbspringboot.resources;

import com.waldstonsantana.mongodbspringboot.models.UserModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> findAll() {
        UserModel maria = new UserModel("1", "Maria Silva", "maria@gmail.com");
        UserModel alex = new UserModel("2", "Alex Silva", "alex@gmail.com");
        List<UserModel> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }


}
