package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.LanguageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LanguageResponse extends BaseResponse {

    private LanguageDto language;

}
