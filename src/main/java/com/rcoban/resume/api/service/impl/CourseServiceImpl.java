package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.CourseDto;
import com.rcoban.resume.api.model.mapper.CourseMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CourseResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.CourseRepository;
import com.rcoban.resume.api.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);

    @Override
    public CourseResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        CourseDto courseDto = Optional.of(courseRepository.findById(id))
                .get()
                .map(courseMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        CourseResponse courseResponse = CourseResponse.builder().course(courseDto).build();
        courseResponse.addSuccessMessage();
        return courseResponse;
    }

    @Override
    public List<CourseDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(courseRepository.findAllByUserId(userId)
                .stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public CourseResponse createNewCourse(CourseDto courseDto) {
        courseDto = Optional.of(courseRepository.save(courseMapper.dtoToEntity(courseDto))).map(courseMapper::entityToDto).orElse(null);

        CourseResponse courseResponse = CourseResponse.builder().course(courseDto).build();
        courseResponse.addSuccessMessage();
        return courseResponse;
    }

    @Override
    public CourseResponse updateById(CourseDto courseDto) {
        if (Objects.isNull(courseDto.getId())) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(courseRepository.findById(courseDto.getId())
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(courseEntity -> courseRepository.save(courseMapper.dtoToEntity(courseDto)));

        CourseResponse courseResponse = CourseResponse.builder().course(courseDto).build();
        courseResponse.addSuccessMessage();
        return courseResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(courseRepository.findById(id)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(courseRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<CourseDto> getDefaultCourses() {
        List<CourseDto> courses = new ArrayList<>();

        CourseDto bilgincAcademy = CourseDto.builder()
                .id(1L)
                .userId(1L)
                .name("Building Applications with Microservices, Docker and Spring Boot")
                .provider("Bilginç IT Academy")
                .build();

        CourseDto linuxSummerSchool = CourseDto.builder()
                .id(2L)
                .userId(1L)
                .name("Spring Framework & Hibernate")
                .provider("Linux Summer School")
                .build();

        CourseDto wissenAkademie = CourseDto.builder()
                .id(3L)
                .userId(1L)
                .name("Java & Database")
                .provider("Wissen Akademie")
                .build();

        courses.add(bilgincAcademy);
        courses.add(linuxSummerSchool);
        courses.add(wissenAkademie);

        return courses;
    }
}
