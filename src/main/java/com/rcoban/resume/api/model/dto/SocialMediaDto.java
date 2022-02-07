package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.SocialMediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaDto {

    private Long id;
    private Long userId;
    private SocialMediaType type;
    private String url;

}
