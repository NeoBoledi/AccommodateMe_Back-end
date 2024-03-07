package com.codemsaters.Accomodate.Me.model;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    private String firstName;
    private String lastName;
    private String contactDetails;
    private String email;
    private String guardianFullName;
    private String guardianContacts;
    private String bursary;
    private String institution;
    private String yearOfStudy;
    private String faculty;
    private Character gender;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


    @Column(name = "applied_at", columnDefinition = "TIMESTAMP")
    private Instant appliedAt;

    @ManyToOne
    @JoinColumn(name = "stud_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    public Application() {
        this.appliedAt = Instant.now();
    }

}
