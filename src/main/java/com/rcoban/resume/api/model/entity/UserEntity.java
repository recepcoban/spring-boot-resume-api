package com.rcoban.resume.api.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    private String email;
    private String fullName;
    private Date birthDate;
    private String phone;
    private String location;

}
