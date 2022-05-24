package com.studiesalexan.mongodbspringboot.resource;


import com.studiesalexan.mongodbspringboot.domain.Post;
import com.studiesalexan.mongodbspringboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postUserService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findByID(@PathVariable String id) {
        Post postUser = postUserService.findById(id);
        return ResponseEntity.ok().body(postUser);
    }


}
