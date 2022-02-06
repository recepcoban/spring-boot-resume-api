package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String title;
    private String fullName;
    private LocalDate birthDate;
    private String phone;
    private String location;
    private String summary;

}
