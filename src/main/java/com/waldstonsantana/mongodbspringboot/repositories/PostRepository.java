package com.waldstonsantana.mongodbspringboot.repositories;

import com.waldstonsantana.mongodbspringboot.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<PostModel, String> {

    List<PostModel> findByTitleContainingIgnoreCase(String text);
}
