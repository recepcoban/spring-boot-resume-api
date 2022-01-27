package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse extends BaseResponse {

    private UserDto user;

}
