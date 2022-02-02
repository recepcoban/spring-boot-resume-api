package com.rcoban.resume.api.model.dto;

import lombok.Data;

@Data
public class CertificationDto {

    private Long id;
    private Long userId;
    private String name;
    private String provider;
    private String url;

}
