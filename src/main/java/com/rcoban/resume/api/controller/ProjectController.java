package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.ProjectDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.ProjectResponse;
import com.rcoban.resume.api.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/project")
@RequiredArgsConstructor
@Tag(name = "Project Services", description = "Project services for some operations with projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all projects by user id")
    public ResponseEntity<List<ProjectDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new project")
    public ResponseEntity<ProjectResponse> createNewProject(@RequestBody @Valid ProjectDto projectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createNewProject(projectDto));
    }

    @PutMapping
    @Operation(summary = "Update a project by its id")
    public ResponseEntity<ProjectResponse> updateById(@RequestBody @Valid ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.updateById(projectDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a project by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.deleteById(id));
    }

}
