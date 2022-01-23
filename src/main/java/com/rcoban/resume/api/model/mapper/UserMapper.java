package com.rcoban.resume.api.model.mapper;

import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userDtoToUserEntity(UserDto userDto);

    UserDto userEntityToUserDto(UserEntity userEntity);

}
