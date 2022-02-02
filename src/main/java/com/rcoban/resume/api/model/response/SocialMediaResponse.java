package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.SocialMediaDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SocialMediaResponse extends BaseResponse {

    private SocialMediaDto socialMedia;

}
