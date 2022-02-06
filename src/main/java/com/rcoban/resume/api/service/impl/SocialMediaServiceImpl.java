package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.SocialMediaDto;
import com.rcoban.resume.api.model.enums.SocialMediaType;
import com.rcoban.resume.api.model.mapper.SocialMediaMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.model.response.SocialMediaResponse;
import com.rcoban.resume.api.repository.SocialMediaRepository;
import com.rcoban.resume.api.service.SocialMediaService;
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
public class SocialMediaServiceImpl implements SocialMediaService {

    private final SocialMediaRepository socialMediaRepository;
    private final SocialMediaMapper socialMediaMapper = Mappers.getMapper(SocialMediaMapper.class);

    @Override
    public SocialMediaResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        SocialMediaDto socialMediaDto = Optional.of(socialMediaRepository.findById(id))
                .get()
                .map(socialMediaMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        SocialMediaResponse socialMediaResponse = SocialMediaResponse.builder().socialMedia(socialMediaDto).build();
        socialMediaResponse.addSuccessMessage();
        return socialMediaResponse;
    }

    @Override
    public List<SocialMediaDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(socialMediaRepository.findAllByUserId(userId)
                .stream()
                .map(socialMediaMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public SocialMediaResponse createNewSocialMedia(SocialMediaDto socialMediaDto) {
        socialMediaDto = Optional.of(socialMediaRepository.save(socialMediaMapper.dtoToEntity(socialMediaDto))).map(socialMediaMapper::entityToDto).orElse(null);

        SocialMediaResponse socialMediaResponse = SocialMediaResponse.builder().socialMedia(socialMediaDto).build();
        socialMediaResponse.addSuccessMessage();
        return socialMediaResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(socialMediaRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(socialMediaRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<SocialMediaDto> getDefaultSocialMedias() {
        List<SocialMediaDto> socialMedias = new ArrayList<>();

        SocialMediaDto linkedin = SocialMediaDto.builder()
                .id(1L)
                .userId(1L)
                .type(SocialMediaType.LINKEDIN)
                .url("linkedin.com/in/recepcoban")
                .build();

        SocialMediaDto github = SocialMediaDto.builder()
                .id(1L)
                .userId(1L)
                .type(SocialMediaType.GITHUB)
                .url("github.com/recepcoban")
                .build();

        socialMedias.add(linkedin);
        socialMedias.add(github);

        return socialMedias;
    }
}
