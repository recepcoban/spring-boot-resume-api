package com.rcoban.resume.api.controller;

import com.rcoban.resume.api.model.dto.SocialMediaDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.SocialMediaResponse;
import com.rcoban.resume.api.service.SocialMediaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resume/social-media")
@RequiredArgsConstructor
@Tag(name = "Social Media Services", description = "Social Media services for some operations with social medias")
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get all social medias by user id")
    public ResponseEntity<List<SocialMediaDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(socialMediaService.getAllByUserId(userId));
    }

    @PostMapping
    @Operation(summary = "Create a new social media")
    public ResponseEntity<SocialMediaResponse> createNewSocialMedia(@RequestBody @Valid SocialMediaDto socialMediaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socialMediaService.createNewSocialMedia(socialMediaDto));
    }

    @PutMapping
    @Operation(summary = "Update a social media")
    public ResponseEntity<SocialMediaResponse> updateById(@RequestBody @Valid SocialMediaDto socialMediaDto) {
        return ResponseEntity.ok(socialMediaService.updateById(socialMediaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a social media by its id")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(socialMediaService.deleteById(id));
    }

}
