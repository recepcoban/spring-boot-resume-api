package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.LanguageDto;
import com.rcoban.resume.api.model.entity.LanguageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageEntity dtoToEntity(LanguageDto dto);

    LanguageDto entityToDto(LanguageEntity entity);

}
