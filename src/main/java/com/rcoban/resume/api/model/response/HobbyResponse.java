package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.HobbyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HobbyResponse extends BaseResponse {

    private HobbyDto hobby;

}
