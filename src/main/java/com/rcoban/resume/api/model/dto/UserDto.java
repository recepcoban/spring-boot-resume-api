package com.rcoban.resume.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotNull(message = "Email address can not be null")
    @NotEmpty(message = "Email address can not be empty")
    @NotBlank(message = "Email address can not be blank")
    @Email(message = "Please provide a valid email address", regexp = ".+@.+\\..+")
    private String email;

    @NotNull(message = "Full Name can not be null")
    private String fullName;

    private String title;
    private LocalDate birthDate;
    private String phone;
    private String location;
    private String summary;

}
