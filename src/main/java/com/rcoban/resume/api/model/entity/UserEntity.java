package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Users")
@SequenceGenerator(name = "seqIdGenerator", initialValue = 100, allocationSize = 100)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdGenerator")
    private Long id;

    @Column(unique = true)
    private String email;

    private String title;
    private String fullName;
    private String employer;
    private LocalDate birthDate;
    private String phone;
    private String location;

    @Column(length = 4000)
    private String summary;

}
