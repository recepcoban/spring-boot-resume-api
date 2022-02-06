package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.HobbyDto;
import com.rcoban.resume.api.model.mapper.HobbyMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.HobbyResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.HobbyRepository;
import com.rcoban.resume.api.service.HobbyService;
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
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepository hobbyRepository;
    private final HobbyMapper hobbyMapper = Mappers.getMapper(HobbyMapper.class);

    @Override
    public HobbyResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        HobbyDto hobbyDto = Optional.of(hobbyRepository.findById(id))
                .get()
                .map(hobbyMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        HobbyResponse hobbyResponse = HobbyResponse.builder().hobby(hobbyDto).build();
        hobbyResponse.addSuccessMessage();
        return hobbyResponse;
    }

    @Override
    public List<HobbyDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(hobbyRepository.findAllByUserId(userId)
                .stream()
                .map(hobbyMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public HobbyResponse createNewHobby(HobbyDto hobbyDto) {
        hobbyDto = Optional.of(hobbyRepository.save(hobbyMapper.dtoToEntity(hobbyDto))).map(hobbyMapper::entityToDto).orElse(null);

        HobbyResponse hobbyResponse = HobbyResponse.builder().hobby(hobbyDto).build();
        hobbyResponse.addSuccessMessage();
        return hobbyResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(hobbyRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(hobbyRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<HobbyDto> getDefaultHobbies() {
        List<HobbyDto> hobbies = new ArrayList<>();

        HobbyDto technology = HobbyDto.builder()
                .id(1L)
                .userId(1L)
                .name("Technology")
                .build();

        HobbyDto coding = HobbyDto.builder()
                .id(2L)
                .userId(1L)
                .name("Coding")
                .build();

        HobbyDto basketball = HobbyDto.builder()
                .id(3L)
                .userId(1L)
                .name("Basketball")
                .build();

        HobbyDto cycling = HobbyDto.builder()
                .id(4L)
                .userId(1L)
                .name("Cycling")
                .build();

        HobbyDto nature = HobbyDto.builder()
                .id(5L)
                .userId(1L)
                .name("Nature")
                .build();

        hobbies.add(technology);
        hobbies.add(coding);
        hobbies.add(basketball);
        hobbies.add(cycling);
        hobbies.add(nature);

        return hobbies;
    }
}
