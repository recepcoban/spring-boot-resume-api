package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.ExperienceDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.ExperienceResponse;
import com.rcoban.resume.api.service.ExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/experience")
@RequiredArgsConstructor
@Tag(name = "Experience Services", description = "Experience services for some operations with experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all experiences by user id")
    public ResponseEntity<List<ExperienceDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(experienceService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new experience")
    public ResponseEntity<ExperienceResponse> createNewExperience(@RequestBody @Valid ExperienceDto experienceDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.createNewExperience(experienceDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a experience by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(experienceService.deleteById(id));
    }

}
