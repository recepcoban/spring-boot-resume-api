package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.response.ResumeResponse;
import com.rcoban.resume.api.service.ResumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
@Tag(name = "Resume Services", description = "Resume services for some operations with details")
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/{email}")
    @Operation(summary = "Get a resume details by user email")
    public ResponseEntity<ResumeResponse> getResumeByUserEmail(@PathVariable String email) {
        return ResponseEntity.ok(resumeService.getResumeByUserEmail(email));
    }

    @GetMapping("/default")
    @Operation(summary = "Get a default resume")
    public ResponseEntity<ResumeResponse> getDefaultResume() {
        return ResponseEntity.ok(resumeService.getDefaultResume());
    }

}
