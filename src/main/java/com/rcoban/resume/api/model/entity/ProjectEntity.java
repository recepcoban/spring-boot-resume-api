package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Projects")
public class ProjectEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String name;
    private String url;

    @Column(length = 4000)
    private String details;

}
