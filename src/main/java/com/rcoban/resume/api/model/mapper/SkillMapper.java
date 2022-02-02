package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.SkillDto;
import com.rcoban.resume.api.model.entity.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    SkillEntity dtoToEntity(SkillDto dto);

    SkillDto entityToDto(SkillEntity entity);

}
