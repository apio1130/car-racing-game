package com.practice.exception;

public class CarNameEmptyException extends RuntimeException {

    private static final String DEFAULT_MSG = "자동차 이름은 공백일 수 없습니다.";

    public CarNameEmptyException() {
        super(DEFAULT_MSG);
    }

    public CarNameEmptyException(String msg) {
        super(msg);
    }
}
