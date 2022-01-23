package com.rcoban.resume.api.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String email;
    private String fullName;
    private Date birthDate;
    private String phone;
    private String location;
    private boolean active;

}
