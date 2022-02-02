package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.ExperienceDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.ExperienceResponse;

import java.util.List;

public interface ExperienceService {

    ExperienceResponse getById(Long id);

    List<ExperienceDto> getAllByUserId(Long userId);

    ExperienceResponse createNewExperience(ExperienceDto experienceDto);

    BaseResponse deleteById(Long id);

}
