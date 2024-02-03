package com.waldstonsantana.mongodbspringboot.repositories;

import com.waldstonsantana.mongodbspringboot.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

}
