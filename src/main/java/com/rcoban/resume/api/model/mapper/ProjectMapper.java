package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.ProjectDto;
import com.rcoban.resume.api.model.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectEntity dtoToEntity(ProjectDto dto);

    ProjectDto entityToDto(ProjectEntity entity);

}
