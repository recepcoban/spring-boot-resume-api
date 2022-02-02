package com.rcoban.resume.api.model.dto;

import lombok.Data;

@Data
public class ProjectDto {

    private Long id;
    private Long userId;
    private String name;
    private String url;
    private String details;

}
