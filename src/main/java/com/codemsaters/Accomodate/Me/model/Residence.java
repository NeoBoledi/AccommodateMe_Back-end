package com.codemsaters.Accomodate.Me.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residence_id")
    private Integer residenceId;

    private String name;
    private int regNo;
    private List<String> utility = new ArrayList<>();
    private String profileImage;
    private List<String> images = new ArrayList<>();
    private String nsfasDocument;

    @OneToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @OneToMany(mappedBy = "residence")
    private List<Room> room;

    @OneToMany(mappedBy = "residence")
    private List<Issues> issues;

    @OneToMany(mappedBy = "residence")
    private List<Review> review;

    @OneToMany(mappedBy = "residence")
    private List<Location> location;

    @OneToMany(mappedBy = "residence")
    private List<Application> application;

}
