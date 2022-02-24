package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.CourseDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CourseResponse;
import com.rcoban.resume.api.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/course")
@RequiredArgsConstructor
@Tag(name = "Course Services", description = "Course services for some operations with courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all courses by user id")
    public ResponseEntity<List<CourseDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(courseService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new course")
    public ResponseEntity<CourseResponse> createNewCourse(@RequestBody @Valid CourseDto courseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createNewCourse(courseDto));
    }

    @PutMapping
    @Operation(summary = "Update a course")
    public ResponseEntity<CourseResponse> updateById(@RequestBody @Valid CourseDto courseDto) {
        return ResponseEntity.ok(courseService.updateById(courseDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a course by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.deleteById(id));
    }

}
