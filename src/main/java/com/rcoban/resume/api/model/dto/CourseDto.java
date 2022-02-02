package com.rcoban.resume.api.model.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long id;
    private Long userId;
    private String name;
    private String provider;

}
