package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.SkillDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.SkillResponse;
import com.rcoban.resume.api.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/skill")
@RequiredArgsConstructor
@Tag(name = "Skill Services", description = "Skill services for some operations with skills")
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/info/{id}")
    @Operation(summary = "Get a skill by its id")
    public ResponseEntity<SkillResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getById(id));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get all skills by user id")
    public ResponseEntity<List<SkillDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(skillService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new skill")
    public ResponseEntity<SkillResponse> createNewSkill(@RequestBody @Valid SkillDto skillDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skillService.createNewSkill(skillDto));
    }

    @PutMapping
    @Operation(summary = "Update a skill")
    public ResponseEntity<SkillResponse> updateById(@RequestBody @Valid SkillDto skillDto) {
        return ResponseEntity.ok(skillService.updateById(skillDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a skill by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.deleteById(id));
    }

}
