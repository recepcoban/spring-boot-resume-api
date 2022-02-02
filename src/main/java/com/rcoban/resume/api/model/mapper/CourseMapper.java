package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.CourseDto;
import com.rcoban.resume.api.model.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseEntity dtoToEntity(CourseDto dto);

    CourseDto entityToDto(CourseEntity entity);

}
