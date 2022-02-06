package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.LanguageDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.LanguageResponse;

import java.util.List;

public interface LanguageService {

    LanguageResponse getById(Long id);

    List<LanguageDto> getAllByUserId(Long userId);

    LanguageResponse createNewLanguage(LanguageDto languageDto);

    BaseResponse deleteById(Long id);

    List<LanguageDto> getDefaultLanguages();

}
