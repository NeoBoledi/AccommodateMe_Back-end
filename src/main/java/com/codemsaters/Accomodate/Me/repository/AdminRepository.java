package com.codemsaters.Accomodate.Me.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemsaters.Accomodate.Me.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

    Optional<Admin> findByEmail(String email);
}