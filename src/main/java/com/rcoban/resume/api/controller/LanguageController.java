package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.LanguageDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.LanguageResponse;
import com.rcoban.resume.api.service.LanguageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/language")
@RequiredArgsConstructor
@Tag(name = "Language Services", description = "Language services for some operations with languages")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all languages by user id")
    public ResponseEntity<List<LanguageDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(languageService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new language")
    public ResponseEntity<LanguageResponse> createNewLanguage(@RequestBody @Valid LanguageDto languageDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.createNewLanguage(languageDto));
    }

    @PutMapping
    @Operation(summary = "Update a language")
    public ResponseEntity<LanguageResponse> updateById(@RequestBody @Valid LanguageDto languageDto) {
        return ResponseEntity.ok(languageService.updateById(languageDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a language by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(languageService.deleteById(id));
    }

}
