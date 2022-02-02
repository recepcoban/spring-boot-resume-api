package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "Experiences")
public class ExperienceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Date startDate;
    private Date endDate;
    private String employer;
    private String position;
    private String responsibilities;

}
