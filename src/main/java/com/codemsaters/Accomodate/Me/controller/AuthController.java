package com.codemsaters.Accomodate.Me.controller;


import com.codemsaters.Accomodate.Me.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;


}
