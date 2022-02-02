package com.rcoban.resume.api.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDto {

    private Long id;
    private Long userId;
    private Date startDate;
    private Date endDate;
    private String employer;
    private String position;
    private String responsibilities;

}
