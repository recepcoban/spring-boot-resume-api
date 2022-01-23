package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.NotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.model.mapper.UserMapper;
import com.rcoban.resume.api.repository.UserRepository;
import com.rcoban.resume.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDto getUserById(String email) {
        if (!StringUtils.hasText(email)) {
            throw new RequiredFieldException();
        }

        return Optional.of(userRepository.findById(email))
                .get()
                .map(userMapper::userEntityToUserDto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public UserDto createNewUser(UserDto userDto) {
        if (!StringUtils.hasText(userDto.getEmail())) {
            throw new RequiredFieldException();
        }

        return Optional.of(userRepository.save(userMapper.userDtoToUserEntity(userDto)))
                .map(userMapper::userEntityToUserDto)
                .get();
    }

    @Override
    public void deleteUserById(String email) {
        if (!StringUtils.hasText(email)) {
            throw new RequiredFieldException();
        }

        Optional.ofNullable(userRepository.findById(email).orElseThrow(NotFoundException::new))
                .ifPresent(userEntity -> {
                    userEntity.setActive(false);
                    userRepository.save(userEntity);
                });
    }

}
