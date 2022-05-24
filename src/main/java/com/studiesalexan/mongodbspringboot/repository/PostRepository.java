package com.studiesalexan.mongodbspringboot.repository;

import com.studiesalexan.mongodbspringboot.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
