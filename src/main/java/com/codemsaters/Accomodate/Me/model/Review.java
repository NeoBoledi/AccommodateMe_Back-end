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

@Entity
@Data
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    private String title;
    private String description;

    @Column(name = "posted_at", columnDefinition = "TIMESTAMP")
    private Instant postedAt;

    @ManyToOne
    @JoinColumn(name = "stud_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    public Review() {
        this.postedAt = Instant.now();
    }

}
