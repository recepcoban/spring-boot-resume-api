package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.HobbyDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.HobbyResponse;

import java.util.List;

public interface HobbyService {

    HobbyResponse getById(Long id);

    List<HobbyDto> getAllByUserId(Long userId);

    HobbyResponse createNewHobby(HobbyDto hobbyDto);

    BaseResponse deleteById(Long id);

}
