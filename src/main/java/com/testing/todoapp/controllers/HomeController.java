package com.testing.todoapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/authenticated")
    public String authenticated() {
        return "Authenticated route";
    }
}
