package com.codemsaters.Accomodate.Me.service;
import com.codemsaters.Accomodate.Me.model.Student;
import com.codemsaters.Accomodate.Me.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class StudentDetailsServiceImplementation implements  StudentDetailsService{
    @Autowired
    private final StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username);


        if(student == null)
        {
            throw  new UsernameNotFoundException("user not found" + username);


        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        System.out.println("Searching for user with username: " + username);

        return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(),authorities);
    }

}
