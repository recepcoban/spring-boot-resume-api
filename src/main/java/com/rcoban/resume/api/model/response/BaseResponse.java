package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.MessageDto;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.Data;

@Data
public class BaseResponse {

    private MessageDto message;

    public void addSuccessMessage() {
        this.setMessage(MessageDto
                .builder()
                .type(MessageUtil.SUCCESS.getType())
                .code(MessageUtil.SUCCESS.getCode())
                .text(MessageUtil.SUCCESS.getText())
                .build());
    }

}
