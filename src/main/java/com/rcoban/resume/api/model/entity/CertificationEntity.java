package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Certifications")
public class CertificationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String name;
    private String provider;
    private String url;

}
