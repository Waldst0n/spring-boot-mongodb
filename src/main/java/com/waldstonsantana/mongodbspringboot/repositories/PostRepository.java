package com.waldstonsantana.mongodbspringboot.repositories;

import com.waldstonsantana.mongodbspringboot.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostModel, String> {

}
