package com.waldstonsantana.mongodbspringboot.config;

import com.waldstonsantana.mongodbspringboot.dto.AuthorDTO;
import com.waldstonsantana.mongodbspringboot.dto.CommentDTO;
import com.waldstonsantana.mongodbspringboot.models.PostModel;
import com.waldstonsantana.mongodbspringboot.models.UserModel;
import com.waldstonsantana.mongodbspringboot.repositories.PostRepository;
import com.waldstonsantana.mongodbspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserModel maria = new UserModel(null, "Maria Brown", "maria@gmail.com");
        UserModel alex = new UserModel(null, "Alex Green", "alex@gmail.com");
        UserModel bob = new UserModel(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        PostModel post1 = new PostModel(null, sdf.parse("21/02/2018"),"Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        PostModel post2 = new PostModel(null,sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hj!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem ",sdf.parse("21/03/2018"),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite! ",sdf.parse("22/03/2018"),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia! ",sdf.parse("24/03/2018"),new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().add(c3);


        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);




    }
}
