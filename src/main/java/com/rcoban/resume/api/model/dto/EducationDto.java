package com.rcoban.resume.api.model.dto;

import lombok.Data;

@Data
public class EducationDto {

    private Long id;
    private Long userId;
    private String startYear;
    private String endYear;
    private String schoolName;
    private String departmentName;


}
