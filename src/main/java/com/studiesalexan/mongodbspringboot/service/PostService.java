package com.studiesalexan.mongodbspringboot.service;

import com.studiesalexan.mongodbspringboot.domain.Post;
import com.studiesalexan.mongodbspringboot.repository.PostRepository;

import com.studiesalexan.mongodbspringboot.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> postUser = postRepository.findById(id);
        return postUser.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitlePost(String text){
        return postRepository.searchTitle(text);
    }

}
