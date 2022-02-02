package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.model.mapper.UserMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.model.response.UserResponse;
import com.rcoban.resume.api.repository.UserRepository;
import com.rcoban.resume.api.service.UserService;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        UserDto userDto = Optional.of(userRepository.findById(id))
                .get()
                .map(userMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        UserResponse userResponse = UserResponse.builder().user(userDto).build();
        userResponse.addSuccessMessage();
        return userResponse;
    }

    @Override
    public UserResponse getByEmail(String email) {
        if (!StringUtils.hasText(email)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.EMAIL_IS_REQUIRED)).build();
        }

        UserDto userDto = Optional.of(userRepository.findByEmail(email))
                .get()
                .map(userMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        UserResponse userResponse = UserResponse.builder().user(userDto).build();
        userResponse.addSuccessMessage();
        return userResponse;
    }

    @Override
    public UserResponse createNewUser(UserDto userDto) {
        userDto = Optional.of(userRepository.save(userMapper.dtoToEntity(userDto))).map(userMapper::entityToDto).orElse(null);

        UserResponse userResponse = UserResponse.builder().user(userDto).build();
        userResponse.addSuccessMessage();
        return userResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(userRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

}
