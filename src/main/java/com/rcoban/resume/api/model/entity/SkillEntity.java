package com.rcoban.resume.api.model.entity;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Skills")
public class SkillEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String name;
    private LevelType level;

}
