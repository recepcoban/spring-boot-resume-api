package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable String email) {
        return userService.getUserById(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewUser(@RequestBody UserDto userDto) {
        return userService.createNewUser(userDto);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable String email) {
        userService.deleteUserById(email);
    }

}
