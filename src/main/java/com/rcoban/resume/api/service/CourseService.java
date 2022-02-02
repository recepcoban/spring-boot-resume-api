package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.CourseDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse getById(Long id);

    List<CourseDto> getAllByUserId(Long userId);

    CourseResponse createNewCourse(CourseDto courseDto);

    BaseResponse deleteById(Long id);

}
