package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.CertificationDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CertificationResponse;

import java.util.List;

public interface CertificationService {

    CertificationResponse getById(Long id);

    List<CertificationDto> getAllByUserId(Long userId);

    CertificationResponse createNewCertification(CertificationDto certificationDto);

    CertificationResponse updateById(CertificationDto certificationDto);

    BaseResponse deleteById(Long id);

    List<CertificationDto> getDefaultCertifications();

}
