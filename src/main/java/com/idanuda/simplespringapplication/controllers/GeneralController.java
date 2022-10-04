package com.idanuda.simplespringapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.idanuda.simplespringapplication.services.GeneralService;

@RestController
public class GeneralController {

    private final GeneralService generalService;

    private GeneralController (GeneralService generalService){
        this.generalService = generalService;
    }


    @GetMapping("/fibonachi/{number}")
    public String fibonachi(@PathVariable Integer number) {
        return "fibu number: " +  generalService.getFibunachi (number, 0, 0, 1) ;
    }





}