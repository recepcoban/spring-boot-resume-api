package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Experiences")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class ExperienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
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
