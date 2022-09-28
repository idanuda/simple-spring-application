package com.idanuda.simplespringapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}