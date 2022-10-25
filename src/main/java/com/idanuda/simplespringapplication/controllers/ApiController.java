package com.idanuda.simplespringapplication.controllers;

import com.idanuda.simplespringapplication.services.SwapiService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ApiController {

    private final SwapiService swapiService;

    public ApiController(SwapiService swapiService){
        this.swapiService = swapiService;
    }

    @GetMapping("/people")
    public Map getAllPeople(HttpServletRequest request, @RequestParam Integer page) {
        return this.swapiService.getAllPeople(page, request.getRequestURL().toString())  ;
    }

    @GetMapping("/people/{id}")
    public Map getPeople(@PathVariable Integer id) {
        return this.swapiService.getPeople(id)  ;
    }
}