package com.rcoban.resume.api.exception;

import com.rcoban.resume.api.model.response.MessageResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequiredFieldException extends RuntimeException {
    private MessageResponse messageResponse;
}
