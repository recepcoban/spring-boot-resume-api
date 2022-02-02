package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.ExperienceDto;
import com.rcoban.resume.api.model.mapper.ExperienceMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.ExperienceResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.ExperienceRepository;
import com.rcoban.resume.api.service.ExperienceService;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper = Mappers.getMapper(ExperienceMapper.class);

    @Override
    public ExperienceResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        ExperienceDto experienceDto = Optional.of(experienceRepository.findById(id))
                .get()
                .map(experienceMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        ExperienceResponse experienceResponse = ExperienceResponse.builder().experience(experienceDto).build();
        experienceResponse.addSuccessMessage();
        return experienceResponse;
    }

    @Override
    public List<ExperienceDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(experienceRepository.findAllByUserId(userId)
                .stream()
                .map(experienceMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public ExperienceResponse createNewExperience(ExperienceDto experienceDto) {
        experienceDto = Optional.of(experienceRepository.save(experienceMapper.dtoToEntity(experienceDto))).map(experienceMapper::entityToDto).orElse(null);

        ExperienceResponse experienceResponse = ExperienceResponse.builder().experience(experienceDto).build();
        experienceResponse.addSuccessMessage();
        return experienceResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(experienceRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(experienceRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

}
