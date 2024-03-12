package com.codemsaters.Accomodate.Me.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    private String fullname;

    private String email;

    private String name;
    private int regNo;
    private List<String> utility = new ArrayList<>();
    private String profileImage;
    private List<String> images = new ArrayList<>();
    private String nsfasDocument;

    @OneToOne(mappedBy = "admin")
    private Residence residence;

}
