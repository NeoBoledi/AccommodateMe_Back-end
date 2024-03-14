package com.codemsaters.Accomodate.Me.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class TestController {

    @GetMapping("/test")
    public String testProject() {

        return "Welcome to our project!";
    }
}
