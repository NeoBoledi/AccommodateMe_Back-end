package com.codemsaters.Accomodate.Me.repositories;

import com.codemsaters.Accomodate.Me.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

     Student findByEmail(String username);
}
