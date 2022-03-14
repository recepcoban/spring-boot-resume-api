package com.rcoban.resume.api.model.entity;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Languages")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    private Long userId;
    private String name;

    @Enumerated(EnumType.STRING)
    private LevelType level;

}
