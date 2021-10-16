package com.angular.javaWithAngular.controller;

import com.angular.javaWithAngular.entity.User;
import com.angular.javaWithAngular.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Of course, the only implementation detail worth noting here is the use of the @CrossOrigin annotation. As the name implies, the annotation enables Cross-Origin Resource Sharing (CORS) on the server.

This step isn't always necessary. Since we are deploying our Angular frontend to http://localhost:4200 and our Boot backend to http://localhost:8080, the browser would otherwise deny requests from one to the other.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);

    }
}
