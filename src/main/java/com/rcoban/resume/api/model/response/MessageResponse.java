package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.MessageDto;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)
public class MessageResponse extends BaseResponse {

    private String stackTrace;
    private List<ValidationError> errors;

    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }

    @Data
    private static class ValidationError {
        private final String field;
        private final String message;
    }

    public static MessageResponse addErrorMessage(MessageUtil messageUtil) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(MessageDto.builder()
                .type(messageUtil.getType())
                .code(messageUtil.getCode())
                .text(messageUtil.getText())
                .build());
        return messageResponse;
    }

}
