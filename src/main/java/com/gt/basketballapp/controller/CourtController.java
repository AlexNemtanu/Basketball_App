package com.gt.basketballapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courts")
public class CourtController {
@GetMapping("/test")
    public String test(){
        return "api is working";
    }
}
