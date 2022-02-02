package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.ExperienceDto;
import com.rcoban.resume.api.model.entity.ExperienceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceEntity dtoToEntity(ExperienceDto dto);

    ExperienceDto entityToDto(ExperienceEntity entity);

}
