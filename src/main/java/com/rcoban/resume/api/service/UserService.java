package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.UserDto;

public interface UserService {

    UserDto getUserById(String email);

    UserDto createNewUser(UserDto userDto);

    void deleteUserById(String email);

}
