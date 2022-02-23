package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.HobbyDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.HobbyResponse;
import com.rcoban.resume.api.service.HobbyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/hobby")
@RequiredArgsConstructor
@Tag(name = "Hobby Services", description = "Hobby services for some operations with hobbies")
public class HobbyController {

    private final HobbyService hobbyService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all hobbies by user id")
    public ResponseEntity<List<HobbyDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(hobbyService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new hobby")
    public ResponseEntity<HobbyResponse> createNewHobby(@RequestBody @Valid HobbyDto hobbyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hobbyService.createNewHobby(hobbyDto));
    }

    @PutMapping
    @Operation(summary = "Update a hobby by its id")
    public ResponseEntity<HobbyResponse> updateById(@RequestBody @Valid HobbyDto hobbyDto) {
        return ResponseEntity.ok(hobbyService.updateById(hobbyDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a hobby by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(hobbyService.deleteById(id));
    }

}
