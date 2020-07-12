package com.mentor.link.persistence.model;

import org.springframework.lang.Nullable;

import java.util.stream.Stream;

public enum Gender {
    MALE(0), FEMALE(1);

    private final int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Nullable
    public static Gender fromCode(int code) {
        if (code < 0) {
            return null;
        }

        return Stream.of(Gender.values())
                .filter(gender -> gender.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
