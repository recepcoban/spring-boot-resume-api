package com.rcoban.resume.api.model.dto;

import com.rcoban.resume.api.model.enums.MessageType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageDto {

    private final MessageType type;
    private final String code;
    private final String text;

}
