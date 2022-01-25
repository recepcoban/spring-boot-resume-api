package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resume/user")
@RequiredArgsConstructor
@Tag(name = "User Services", description = "User services for some operations with users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a user by its email")
    public UserDto getUserById(@PathVariable String email) {
        return userService.getUserById(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user")
    public UserDto createNewUser(@RequestBody @Valid UserDto userDto) {
        return userService.createNewUser(userDto);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a user by its email")
    public void deleteUserById(@PathVariable String email) {
        userService.deleteUserById(email);
    }

}
