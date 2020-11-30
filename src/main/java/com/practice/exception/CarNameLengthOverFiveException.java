package com.practice.exception;

public class CarNameLengthOverFiveException extends RuntimeException {

    private static final String DEFAULT_MSG = "자동차 이름은 5글자 이하만 가능합니다.";

    public CarNameLengthOverFiveException() {
        super(DEFAULT_MSG);
    }

    public CarNameLengthOverFiveException(String msg) {
        super(msg);
    }
}
