package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Projects")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    private Long userId;
    private String name;
    private String url;

    @Column(length = 4000)
    private String details;

}
