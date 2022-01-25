package com.rcoban.resume.api.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    private String fullName;
    private Date birthDate;
    private String phone;
    private String location;
    private boolean active;

}
