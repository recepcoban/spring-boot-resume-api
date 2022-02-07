package com.rcoban.resume.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

    private Long id;
    private Long userId;
    private String startYear;
    private String endYear;
    private String schoolName;
    private String departmentName;


}
