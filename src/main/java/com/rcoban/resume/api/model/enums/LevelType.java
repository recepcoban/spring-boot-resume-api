package com.rcoban.resume.api.model.enums;

public enum LevelType {
    BEGINNER(1, "BEGINNER"),
    ELEMENTARY(2, "ELEMENTARY"),
    INTERMEDIATE(3, "INTERMEDIATE"),
    UPPER_INTERMEDIATE(4, "UPPER_INTERMEDIATE"),
    ADVANCED(5, "ADVANCED"),
    PROFICIENT(6, "PROFICIENT");

    Integer code;
    String name;

    LevelType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
