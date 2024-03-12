package com.codemsaters.Accomodate.Me.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "applied_at", columnDefinition = "TIMESTAMP")
    private Instant appliedAt;

    @ManyToOne
    @JoinColumn(name = "stud_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Application() {
        this.appliedAt = Instant.now();
    }

}
