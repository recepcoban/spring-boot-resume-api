package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Educations")
public class EducationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String schoolName;
    private String departmentName;
    private boolean active;

}
