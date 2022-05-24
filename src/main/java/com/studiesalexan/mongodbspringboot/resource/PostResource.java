package com.studiesalexan.mongodbspringboot.resource;


import com.studiesalexan.mongodbspringboot.domain.Post;
import com.studiesalexan.mongodbspringboot.resource.util.URL;
import com.studiesalexan.mongodbspringboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = " ") String text) {
        text = URL.decodeParam(text);
        List<Post> postList = postUserService.findByTitlePost(text);
        return ResponseEntity.ok().body(postList);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullTitle(@RequestParam(value = "text", defaultValue = " ") String text, @RequestParam(value = "minDate", defaultValue = " ") String minDate, @RequestParam(value = "maxDate", defaultValue = " ") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> postList = postUserService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(postList);
    }
}
