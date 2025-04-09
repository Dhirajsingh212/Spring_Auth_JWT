package com.testing.todoapp.service;

import com.testing.todoapp.model.User;

public interface UserService {
    public User createNewUser(User user);
    public String validateUser(User user);
}
