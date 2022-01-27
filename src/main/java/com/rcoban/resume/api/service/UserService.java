package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.UserResponse;

public interface UserService {

    UserResponse getUserById(String email);

    UserResponse createNewUser(UserDto userDto);

    BaseResponse deleteUserById(String email);

}
