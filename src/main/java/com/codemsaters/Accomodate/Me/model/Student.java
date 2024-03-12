package com.codemsaters.Accomodate.Me.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private Integer studId;

    private Integer studentId;
    private String fullName;
    private String contactDetails;
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "student")
    private List<Review> review;

    @OneToMany(mappedBy = "student")
    private List<Issues> issues;

    @OneToMany(mappedBy = "student")
    private List<Application> application;

}
