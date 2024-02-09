package com.waldstonsantana.mongodbspringboot.services;

import com.waldstonsantana.mongodbspringboot.models.PostModel;
import com.waldstonsantana.mongodbspringboot.repositories.PostRepository;
import com.waldstonsantana.mongodbspringboot.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public PostModel findById(String id) {
        PostModel post = postRepository.findById(id).get();
        if (post == null)  {
            throw new NotFoundException("Objeto não encontrado!");
        }
        return post;
    }

    public List<PostModel> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }


}
