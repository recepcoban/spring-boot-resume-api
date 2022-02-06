package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.LanguageDto;
import com.rcoban.resume.api.model.enums.LevelType;
import com.rcoban.resume.api.model.mapper.LanguageMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.LanguageResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.LanguageRepository;
import com.rcoban.resume.api.service.LanguageService;
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
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper = Mappers.getMapper(LanguageMapper.class);

    @Override
    public LanguageResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        LanguageDto languageDto = Optional.of(languageRepository.findById(id))
                .get()
                .map(languageMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        LanguageResponse languageResponse = LanguageResponse.builder().language(languageDto).build();
        languageResponse.addSuccessMessage();
        return languageResponse;
    }

    @Override
    public List<LanguageDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(languageRepository.findAllByUserId(userId)
                .stream()
                .map(languageMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public LanguageResponse createNewLanguage(LanguageDto languageDto) {
        languageDto = Optional.of(languageRepository.save(languageMapper.dtoToEntity(languageDto))).map(languageMapper::entityToDto).orElse(null);

        LanguageResponse languageResponse = LanguageResponse.builder().language(languageDto).build();
        languageResponse.addSuccessMessage();
        return languageResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(languageRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(languageRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<LanguageDto> getDefaultLanguages() {
        List<LanguageDto> languages = new ArrayList<>();

        LanguageDto english = LanguageDto.builder()
                .id(1L)
                .userId(1L)
                .name("English")
                .level(LevelType.ADVANCED)
                .build();

        LanguageDto turkish = LanguageDto.builder()
                .id(2L)
                .userId(1L)
                .name("Turkish")
                .level(LevelType.PROFICIENT)
                .build();

        languages.add(english);
        languages.add(turkish);

        return languages;
    }
}
