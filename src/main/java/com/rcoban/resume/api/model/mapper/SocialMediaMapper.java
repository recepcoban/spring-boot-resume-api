package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.SocialMediaDto;
import com.rcoban.resume.api.model.entity.SocialMediaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SocialMediaMapper {

    SocialMediaEntity dtoToEntity(SocialMediaDto dto);

    SocialMediaDto entityToDto(SocialMediaEntity entity);

}
