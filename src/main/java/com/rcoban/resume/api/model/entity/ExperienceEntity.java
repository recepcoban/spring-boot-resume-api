package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Experiences")
public class ExperienceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employer;
    private String url;
    private String position;

    @Column(length = 4000)
    private String responsibilities;

    private boolean active;

}
