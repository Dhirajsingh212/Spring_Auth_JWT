package com.testing.todoapp.controllers;

import com.testing.todoapp.model.User;
import com.testing.todoapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/createnew")
    public ResponseEntity<User> createNewUser(@RequestBody User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return new ResponseEntity<>(userService.createNewUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody User newUser) {
        return userService.validateUser(newUser);
    }
}
