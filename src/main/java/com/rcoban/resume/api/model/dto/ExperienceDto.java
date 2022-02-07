package com.rcoban.resume.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

    private Long id;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employer;
    private String position;
    private String responsibilities;

}
