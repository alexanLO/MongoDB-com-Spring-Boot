package com.studiesalexan.mongodbspringboot.config;

import com.studiesalexan.mongodbspringboot.domain.Post;
import com.studiesalexan.mongodbspringboot.domain.User;
import com.studiesalexan.mongodbspringboot.dto.AuthorDTO;
import com.studiesalexan.mongodbspringboot.dto.CommentDTO;
import com.studiesalexan.mongodbspringboot.repository.PostRepository;
import com.studiesalexan.mongodbspringboot.repository.UserRepository;
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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GTM"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post01 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post02 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO comment01 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment02 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO comment03 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post01.getCommentDTOS().addAll(Arrays.asList(comment01, comment03));
        post02.getCommentDTOS().add(comment02);


        postRepository.saveAll(Arrays.asList(post01, post02));

        maria.getPosts().addAll(Arrays.asList(post01, post02));
        userRepository.save(maria);
    }
}
