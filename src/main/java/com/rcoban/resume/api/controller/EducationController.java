package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.EducationDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.EducationResponse;
import com.rcoban.resume.api.service.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/education")
@RequiredArgsConstructor
@Tag(name = "Education Services", description = "Education services for some operations with educations")
public class EducationController {

    private final EducationService educationService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all educations by user id")
    public ResponseEntity<List<EducationDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(educationService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new education")
    public ResponseEntity<EducationResponse> createNewEducation(@RequestBody @Valid EducationDto educationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationService.createNewEducation(educationDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a education by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.deleteById(id));
    }

}
