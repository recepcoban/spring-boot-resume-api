package com.rcoban.resume.api.utils;

import com.rcoban.resume.api.model.enums.MessageType;

public enum MessageUtil {
    SUCCESS("E0000", "Success!", MessageType.INFO),
    UNKNOWN_ERROR("E9999", "Unknown error occurred!", MessageType.ERROR),
    ID_IS_REQUIRED("E0001", "ID is required!", MessageType.WARNING),
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

}
