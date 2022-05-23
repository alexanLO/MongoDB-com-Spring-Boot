package com.studiesalexan.mongodbspringboot.service;

import com.studiesalexan.mongodbspringboot.domain.User;
import com.studiesalexan.mongodbspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
