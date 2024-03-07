package com.codemsaters.Accomodate.Me.service;

import com.codemsaters.Accomodate.Me.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation {
    @Autowired
    private StudentRepository studentRepository;


}
