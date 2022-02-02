package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.CertificationDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CertificationResponse;
import com.rcoban.resume.api.service.CertificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/certification")
@RequiredArgsConstructor
@Tag(name = "Certification Services", description = "Certification services for some operations with certifications")
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all certifications by user id")
    public ResponseEntity<List<CertificationDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(certificationService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new certification")
    public ResponseEntity<CertificationResponse> createNewCertification(@RequestBody @Valid CertificationDto certificationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(certificationService.createNewCertification(certificationDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a certification by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(certificationService.deleteById(id));
    }

}
