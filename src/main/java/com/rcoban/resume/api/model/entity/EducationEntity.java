package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Educations")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class EducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String schoolName;
    private String departmentName;
    private boolean active;

}
