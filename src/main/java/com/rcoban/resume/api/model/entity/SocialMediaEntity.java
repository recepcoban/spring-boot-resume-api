package com.rcoban.resume.api.model.entity;

import com.rcoban.resume.api.model.enums.SocialMediaType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SocialMedias")
public class SocialMediaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private SocialMediaType type;
    private String url;

}
