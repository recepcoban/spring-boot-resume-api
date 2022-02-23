package com.rcoban.resume.api.model.entity;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Skills")
public class SkillEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String name;

    @Enumerated(EnumType.STRING)
    private LevelType level;

}
