package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LanguageDto {

    private Long id;
    private Long userId;
    private String name;
    private LevelType level;

}
