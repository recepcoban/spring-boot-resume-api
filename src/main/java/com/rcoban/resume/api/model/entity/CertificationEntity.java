package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Certifications")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class CertificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    private Long userId;
    private String name;
    private String provider;
    private String url;

}
