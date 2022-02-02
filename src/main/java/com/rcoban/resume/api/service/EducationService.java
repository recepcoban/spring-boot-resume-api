package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.EducationDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.EducationResponse;

import java.util.List;

public interface EducationService {

    EducationResponse getById(Long id);

    List<EducationDto> getAllByUserId(Long userId);

    EducationResponse createNewEducation(EducationDto educationDto);

    BaseResponse deleteById(Long id);

}
