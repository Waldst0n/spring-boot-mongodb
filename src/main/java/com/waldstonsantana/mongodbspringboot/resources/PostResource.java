package com.waldstonsantana.mongodbspringboot.resources;

import com.waldstonsantana.mongodbspringboot.dto.UserDTO;
import com.waldstonsantana.mongodbspringboot.models.PostModel;
import com.waldstonsantana.mongodbspringboot.models.UserModel;
import com.waldstonsantana.mongodbspringboot.resources.util.URL;
import com.waldstonsantana.mongodbspringboot.services.PostService;
import com.waldstonsantana.mongodbspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService userService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostModel> findById(@PathVariable String id) {
        PostModel obj = userService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostModel>> findByTitle(@RequestParam(value ="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<PostModel> list = userService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

}
