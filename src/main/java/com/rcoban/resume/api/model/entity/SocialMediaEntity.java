package com.rcoban.resume.api.model.entity;

import com.rcoban.resume.api.model.enums.SocialMediaType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SocialMedias")
public class SocialMediaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private SocialMediaType type;
    private String url;

}
