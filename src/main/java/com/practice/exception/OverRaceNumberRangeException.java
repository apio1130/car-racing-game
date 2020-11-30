package com.practice.exception;

public class OverRaceNumberRangeException extends  RuntimeException {
    private static final String DEFAULT_MESSAGE = "1~9까지의 숫자만 가능합니다.";

    public OverRaceNumberRangeException() {
        super(DEFAULT_MESSAGE);
    }

    public OverRaceNumberRangeException(String message) {
        super(message);
    }
}
