package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.EducationDto;
import com.rcoban.resume.api.model.mapper.EducationMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.EducationResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.EducationRepository;
import com.rcoban.resume.api.service.EducationService;
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
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper = Mappers.getMapper(EducationMapper.class);

    @Override
    public EducationResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        EducationDto educationDto = Optional.of(educationRepository.findById(id))
                .get()
                .map(educationMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        EducationResponse educationResponse = EducationResponse.builder().education(educationDto).build();
        educationResponse.addSuccessMessage();
        return educationResponse;
    }

    @Override
    public List<EducationDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(educationRepository.findAllByUserId(userId)
                .stream()
                .map(educationMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public EducationResponse createNewEducation(EducationDto educationDto) {
        educationDto = Optional.of(educationRepository.save(educationMapper.dtoToEntity(educationDto))).map(educationMapper::entityToDto).orElse(null);

        EducationResponse educationResponse = EducationResponse.builder().education(educationDto).build();
        educationResponse.addSuccessMessage();
        return educationResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(educationRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(educationRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<EducationDto> getDefaultEducations() {
        List<EducationDto> educations = new ArrayList<>();

        EducationDto istanbulUniversity = EducationDto.builder()
                .id(1L)
                .userId(1L)
                .startYear("2010")
                .endYear("2015")
                .schoolName("Istanbul University")
                .departmentName("Computer Engineering")
                .build();

        educations.add(istanbulUniversity);

        return educations;
    }
}
