package com.waldstonsantana.mongodbspringboot.repositories;

import com.waldstonsantana.mongodbspringboot.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<PostModel, String> {


    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<PostModel> searchTitle(String text);
    List<PostModel> findByTitleContainingIgnoreCase(String text);

}
