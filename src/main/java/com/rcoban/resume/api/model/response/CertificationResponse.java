package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.CertificationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CertificationResponse extends BaseResponse {

    private CertificationDto certification;

}
