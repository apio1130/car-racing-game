package com.practice.exception;

public class NegativePositionException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "위치 값은 음수일 수 없습니다.";

    public NegativePositionException() {
        super((DEFAULT_MESSAGE));
    }

    public NegativePositionException(String message) {
        super(message);
    }
}
