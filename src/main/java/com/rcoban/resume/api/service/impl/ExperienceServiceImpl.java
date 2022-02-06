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

import java.time.LocalDate;
import java.util.ArrayList;
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

    @Override
    public List<ExperienceDto> getDefaultExperiences() {
        List<ExperienceDto> experiences = new ArrayList<>();

        ExperienceDto mapfre = ExperienceDto.builder()
                .id(1L)
                .userId(1L)
                .startDate(LocalDate.of(2015, 11, 1))
                .endDate(LocalDate.of(2017, 2, 1))
                .employer("Mapfre Insurance - mapfre.com.tr")
                .position("Software Developer")
                .responsibilities("Developing and maintaining an insurance project.\n" +
                        "Developing with Java, JSF, Web services(SOAP), Oracle.")
                .build();

        ExperienceDto yapiKredi = ExperienceDto.builder()
                .id(2L)
                .userId(1L)
                .startDate(LocalDate.of(2017, 3, 1))
                .endDate(LocalDate.now())
                .employer("Yapı Kredi Bank - yapikredi.com.tr")
                .position("Senior Software Developer")
                .responsibilities("Working with Insurance Department.\n" +
                        "Developing and maintaining a detailed banking and insurance project.\n" +
                        "Developing with Java, Spring Boot, Web services(SOAP, Rest), Oracle, React Js. Html,\n" +
                        "Css(Bootstrap, Ant Design).")
                .build();

        experiences.add(mapfre);
        experiences.add(yapiKredi);

        return experiences;
    }
}
