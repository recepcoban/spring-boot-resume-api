package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.SkillDto;
import com.rcoban.resume.api.model.enums.LevelType;
import com.rcoban.resume.api.model.mapper.SkillMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.model.response.SkillResponse;
import com.rcoban.resume.api.repository.SkillRepository;
import com.rcoban.resume.api.service.SkillService;
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
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper = Mappers.getMapper(SkillMapper.class);

    @Override
    public SkillResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        SkillDto skillDto = Optional.of(skillRepository.findById(id))
                .get()
                .map(skillMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        SkillResponse skillResponse = SkillResponse.builder().skill(skillDto).build();
        skillResponse.addSuccessMessage();
        return skillResponse;
    }

    @Override
    public List<SkillDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(skillRepository.findAllByUserId(userId)
                .stream()
                .map(skillMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public SkillResponse createNewSkill(SkillDto skillDto) {
        skillDto = Optional.of(skillRepository.save(skillMapper.dtoToEntity(skillDto))).map(skillMapper::entityToDto).orElse(null);

        SkillResponse skillResponse = SkillResponse.builder().skill(skillDto).build();
        skillResponse.addSuccessMessage();
        return skillResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(skillRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(skillRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<SkillDto> getDefaultSkills() {
        List<SkillDto> skills = new ArrayList<>();

        SkillDto java = SkillDto.builder()
                .id(1L)
                .userId(1L)
                .name("Java")
                .level(LevelType.ADVANCED)
                .build();

        SkillDto springBoot = SkillDto.builder()
                .id(2L)
                .userId(1L)
                .name("Spring Boot")
                .level(LevelType.ADVANCED)
                .build();

        SkillDto webServices = SkillDto.builder()
                .id(3L)
                .userId(1L)
                .name("Web Services(SOAP, REST)")
                .level(LevelType.ADVANCED)
                .build();

        SkillDto atlassian = SkillDto.builder()
                .id(4L)
                .userId(1L)
                .name("Atlassian(JIRA, Bitbucket, Bamboo)")
                .level(LevelType.ADVANCED)
                .build();

        SkillDto reactJs = SkillDto.builder()
                .id(5L)
                .userId(1L)
                .name("React Js")
                .level(LevelType.UPPER_INTERMEDIATE)
                .build();

        skills.add(java);
        skills.add(springBoot);
        skills.add(webServices);
        skills.add(atlassian);
        skills.add(reactJs);

        return skills;
    }
}
