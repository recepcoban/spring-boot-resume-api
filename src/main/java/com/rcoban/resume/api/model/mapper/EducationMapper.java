package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.EducationDto;
import com.rcoban.resume.api.model.entity.EducationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    EducationEntity dtoToEntity(EducationDto dto);

    EducationDto entityToDto(EducationEntity entity);

}
