package com.rcoban.resume.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private Long userId;
    private String name;
    private String url;
    private String details;

}
