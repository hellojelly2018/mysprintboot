package com.study.boot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "This is springboot2 home page.";
    }
}
