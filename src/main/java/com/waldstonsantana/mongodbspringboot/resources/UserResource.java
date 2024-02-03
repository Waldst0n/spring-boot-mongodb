package com.waldstonsantana.mongodbspringboot.resources;

import com.waldstonsantana.mongodbspringboot.dto.UserDTO;
import com.waldstonsantana.mongodbspringboot.models.UserModel;

import com.waldstonsantana.mongodbspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserModel> list = userService.findAll();
        List<UserDTO> listDtos = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDtos);
    }


}
