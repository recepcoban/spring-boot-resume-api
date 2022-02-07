package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

    private Long id;
    private Long userId;
    private String name;
    private LevelType level;

}
