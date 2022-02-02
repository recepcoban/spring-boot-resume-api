package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullName;
    private Date birthDate;
    private String phone;
    private String location;
    private String summary;

}
