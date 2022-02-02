package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.LevelType;
import lombok.Data;

@Data
public class SkillDto {

    private Long id;
    private Long userId;
    private String name;
    private LevelType level;

}
