package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.SocialMediaDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.SocialMediaResponse;

import java.util.List;

public interface SocialMediaService {

    SocialMediaResponse getById(Long id);

    List<SocialMediaDto> getAllByUserId(Long userId);

    SocialMediaResponse createNewSocialMedia(SocialMediaDto socialMediaDto);

    BaseResponse deleteById(Long id);

    List<SocialMediaDto> getDefaultSocialMedias();

}
