package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.UserDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.UserResponse;
import com.rcoban.resume.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resume/user")
@RequiredArgsConstructor
@Tag(name = "User Services", description = "User services for some operations with users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    @Operation(summary = "Get a user by its email")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<UserResponse> createNewUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

}
