package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.DataNotFoundException;
import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.CertificationDto;
import com.rcoban.resume.api.model.mapper.CertificationMapper;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.CertificationResponse;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.repository.CertificationRepository;
import com.rcoban.resume.api.service.CertificationService;
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
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper = Mappers.getMapper(CertificationMapper.class);

    @Override
    public CertificationResponse getById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        CertificationDto certificationDto = Optional.of(certificationRepository.findById(id))
                .get()
                .map(certificationMapper::entityToDto)
                .orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build());

        CertificationResponse certificationResponse = CertificationResponse.builder().certification(certificationDto).build();
        certificationResponse.addSuccessMessage();
        return certificationResponse;
    }

    @Override
    public List<CertificationDto> getAllByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        return Optional.of(certificationRepository.findAllByUserId(userId)
                .stream()
                .map(certificationMapper::entityToDto)
                .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public CertificationResponse createNewCertification(CertificationDto certificationDto) {
        certificationDto = Optional.of(certificationRepository.save(certificationMapper.dtoToEntity(certificationDto))).map(certificationMapper::entityToDto).orElse(null);

        CertificationResponse certificationResponse = CertificationResponse.builder().certification(certificationDto).build();
        certificationResponse.addSuccessMessage();
        return certificationResponse;
    }

    @Override
    public BaseResponse deleteById(Long id) {
        if (Objects.isNull(id)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.ID_IS_REQUIRED)).build();
        }

        Optional.ofNullable(certificationRepository.findById(id).orElseThrow(() -> DataNotFoundException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.DATA_NOT_FOUND)).build()))
                .ifPresent(certificationRepository::delete);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.addSuccessMessage();
        return baseResponse;
    }

    @Override
    public List<CertificationDto> getDefaultCertifications() {
        List<CertificationDto> certifications = new ArrayList<>();

        CertificationDto oracle = CertificationDto.builder()
                .id(1L)
                .userId(1L)
                .name("Oracle Certified Associate, Java SE 8 Programmer")
                .provider("Oracle")
                .url("https://www.credly.com/badges/7ed48c34-aa04-4920-806e-3d7696f5c806")
                .build();

        CertificationDto bilgincAcademy = CertificationDto.builder()
                .id(2L)
                .userId(1L)
                .name("Building Applications with Microservices, Docker and Spring Boot")
                .provider("Bilginç IT Academy")
                .url("https://bilginc.com/evaluation/view/BC000267312")
                .build();

        certifications.add(oracle);
        certifications.add(bilgincAcademy);

        return certifications;
    }
}
