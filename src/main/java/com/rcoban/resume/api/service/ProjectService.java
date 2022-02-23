package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.ProjectDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse getById(Long id);

    List<ProjectDto> getAllByUserId(Long userId);

    ProjectResponse createNewProject(ProjectDto projectDto);

    ProjectResponse updateById(ProjectDto projectDto);

    BaseResponse deleteById(Long id);

    List<ProjectDto> getDefaultProjects();

}
