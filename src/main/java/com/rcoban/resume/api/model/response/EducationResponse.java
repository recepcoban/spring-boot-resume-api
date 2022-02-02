package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.EducationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EducationResponse extends BaseResponse {

    private EducationDto education;

}
