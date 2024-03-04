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
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issues_id")
    private Integer issuesId;

    private String title;
    private String priority;
    private String description;
    private String status;

    @Column(name = "reported_at", columnDefinition = "TIMESTAMP")
    private Instant reportedAt;

    @Column(name = "solved_at", columnDefinition = "TIMESTAMP")
    private Instant solvedAt;

    @ManyToOne
    @JoinColumn(name = "stud_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    public Issues() {
        this.reportedAt = Instant.now();
        this.solvedAt = Instant.now();
    }

}
