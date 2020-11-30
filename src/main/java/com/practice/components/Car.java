package com.practice.components;

import com.practice.exception.CarNameEmptyException;
import com.practice.exception.CarNameLengthOverFiveException;

public class Car {

    private String name;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new CarNameEmptyException();
        }
        if (name.length() > 5) {
            throw new CarNameLengthOverFiveException();
        }

        this.name = name;
    }

}
