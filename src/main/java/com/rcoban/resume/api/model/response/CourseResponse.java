package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.CourseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseResponse extends BaseResponse {

    private CourseDto course;

}
