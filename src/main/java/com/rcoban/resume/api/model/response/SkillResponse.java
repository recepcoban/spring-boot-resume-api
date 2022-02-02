package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.SkillDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillResponse extends BaseResponse {

    private SkillDto skill;

}
