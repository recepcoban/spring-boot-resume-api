package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Hobbies")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class HobbyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    private Long userId;
    private String name;

}
