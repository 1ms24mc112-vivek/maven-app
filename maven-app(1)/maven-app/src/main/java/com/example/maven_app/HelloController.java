package com.example.maven_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello works ";
    }

    @GetMapping("/")
    public String home() {
        return "Home works ";
    }
}
