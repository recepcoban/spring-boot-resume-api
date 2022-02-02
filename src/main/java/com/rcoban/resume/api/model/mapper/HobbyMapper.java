package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.HobbyDto;
import com.rcoban.resume.api.model.entity.HobbyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HobbyMapper {

    HobbyEntity dtoToEntity(HobbyDto dto);

    HobbyDto entityToDto(HobbyEntity entity);

}
