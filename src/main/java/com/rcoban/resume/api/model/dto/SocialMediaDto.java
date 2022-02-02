package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.SocialMediaType;
import lombok.Data;

@Data
public class SocialMediaDto {

    private Long id;
    private Long userId;
    private SocialMediaType type;
    private String url;

}
