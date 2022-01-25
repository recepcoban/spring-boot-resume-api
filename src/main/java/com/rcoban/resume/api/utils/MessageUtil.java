package com.rcoban.resume.api.utils;

import com.rcoban.resume.api.model.enums.MessageType;

public enum MessageUtil {
    SUCCESS("E0000", "Success!", MessageType.INFO),
    UNKNOWN_ERROR("E0001", "Unknown error occurred!", MessageType.ERROR),
    EMAIL_IS_REQUIRED("E0002", "Email is required!", MessageType.WARNING),
    DATA_NOT_FOUND("E0003", "Data not found!", MessageType.ERROR),
    VALIDATION_ERROR("E0004", "Validation error. Check 'errors' field for details.", MessageType.ERROR);

    String code;
    String text;
    MessageType type;

    MessageUtil(String code, String text, MessageType type) {
        this.code = code;
        this.text = text;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public MessageType getType() {
        return type;
    }

    public static MessageUtil getMessageByCode(String code) {
        MessageUtil messageUtil = MessageUtil.UNKNOWN_ERROR;
        for (MessageUtil message : MessageUtil.values()) {
            if (message.getCode().equals(code)) {
                messageUtil = message;
                break;
            }
        }
        return messageUtil;
    }
}
