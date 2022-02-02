package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.ExperienceDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExperienceResponse extends BaseResponse {

    private ExperienceDto experience;

}
