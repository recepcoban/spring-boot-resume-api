package com.rcoban.resume.api.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserDto {

    @NotNull(message = "Email address can not be null")
    @NotEmpty(message = "Email address can not be empty")
    @NotBlank(message = "Email address can not be blank")
    @Email(message = "Please provide a valid email address", regexp = ".+@.+\\..+")
    private String email;

    @NotNull(message = "Full Name can not be null")
    private String fullName;

    private Date birthDate;
    private String phone;
    private String location;

}
