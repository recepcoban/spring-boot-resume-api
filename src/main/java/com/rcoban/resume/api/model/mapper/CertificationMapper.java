package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.CertificationDto;
import com.rcoban.resume.api.model.entity.CertificationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificationMapper {

    CertificationEntity dtoToEntity(CertificationDto dto);

    CertificationDto entityToDto(CertificationEntity entity);

}
