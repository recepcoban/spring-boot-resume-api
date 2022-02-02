package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.ProjectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectResponse extends BaseResponse {

    private ProjectDto project;

}
