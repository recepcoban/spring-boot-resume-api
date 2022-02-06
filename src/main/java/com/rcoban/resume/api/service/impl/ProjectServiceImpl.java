package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.ProjectDto;
import com.rcoban.resume.api.model.mapper.ProjectMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.model.response.ProjectResponse;
import com.rcoban.resume.api.repository.ProjectRepository;
import com.rcoban.resume.api.service.ProjectService;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    @Override
    public ProjectResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        ProjectDto projectDto = Optional.of(projectRepository.findById(id))
                .get()
                .map(projectMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        ProjectResponse projectResponse = ProjectResponse.builder().project(projectDto).build();
        projectResponse.addSuccessMessage();
        return projectResponse;
    }

    @Override
    public List<ProjectDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(projectRepository.findAllByUserId(userId)
                .stream()
                .map(projectMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public ProjectResponse createNewProject(ProjectDto projectDto) {
        projectDto = Optional.of(projectRepository.save(projectMapper.dtoToEntity(projectDto))).map(projectMapper::entityToDto).orElse(null);

        ProjectResponse projectResponse = ProjectResponse.builder().project(projectDto).build();
        projectResponse.addSuccessMessage();
        return projectResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(projectRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(projectRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<ProjectDto> getDefaultProjects() {
        List<ProjectDto> projects = new ArrayList<>();

        ProjectDto insurance = ProjectDto.builder()
                .id(1L)
                .userId(1L)
                .name("Yapı Kredi Bank - Bancassurance")
                .url(null)
                .details("- This is an Insurance Project of the Insurance Department which includes many products. Such as belows;\n" +
                        "* My Goods Insurance\n" +
                        "* My Work Insurance\n" +
                        "* Health Insurance\n" +
                        "* Natural Disaster Insurance\n" +
                        "* Motor Insurance\n" +
                        "* Life Insurance\n" +
                        "* Private Pension System\n" +
                        "- Developing and maintaining all of the products of the project.\n" +
                        "- Working on every process of the products. Backend, frontend, database.\n" +
                        "- Developing with Java, Spring Boot, Rest, SOAP, React Js, Oracle, Harmoni(Framework based on Java, Spring, Html,\n" +
                        "Css, Bootstrap)")
                .build();

        ProjectDto offerte = ProjectDto.builder()
                .id(2L)
                .userId(1L)
                .name("Offerte - ePunkt(Freelance)")
                .url("www.offerte-epunkt.ch")
                .details("- A company which is works for cleaning, moving, painting and flooring business line.\n" +
                        "- I worked on backend, frontend and database of the project as a fullstack developer.\n" +
                        "- Developing with C#, ASP.NET, MSSQL, HTML, CSS(Bootstrap).")
                .build();

        ProjectDto socialMedia = ProjectDto.builder()
                .id(3L)
                .userId(1L)
                .name("Social Media Monitoring System")
                .url(null)
                .details("- Searching with some special keyword on social media like facebook, twitter etc.\n" +
                        "- Reporting data with data visualization tools.\n" +
                        "- Developing with Java, MySQL.\n" +
                        "- Using apigee.com's APIs.")
                .build();

        projects.add(insurance);
        projects.add(offerte);
        projects.add(socialMedia);

        return projects;
    }
}
