package com.studiesalexan.mongodbspringboot.resource;


import com.studiesalexan.mongodbspringboot.domain.User;
import com.studiesalexan.mongodbspringboot.dto.UserDTO;
import com.studiesalexan.mongodbspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }
}
