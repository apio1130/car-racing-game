package com.practice.components;

import com.practice.exception.CarNameEmptyException;
import com.practice.exception.CarNameLengthOverFiveException;
import com.practice.exception.NegativePositionException;
import com.practice.exception.OverRaceNumberRangeException;

public class Car {

    private String name;

    private int position;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new CarNameEmptyException();
        }
        if (name.length() > 5) {
            throw new CarNameLengthOverFiveException();
        }

        this.name = name;
    }

    public Car(String name, int position) {
        if (name == null || name.isEmpty()) {
            throw new CarNameEmptyException();
        }
        if (name.length() > 5) {
            throw new CarNameLengthOverFiveException();
        }

        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number < 1 || number > 9) {
            throw new OverRaceNumberRangeException();
        }

        if (number >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public static Car of(final String name, final int position) {
        if (position < 0) {
            throw new NegativePositionException();
        }
        return new Car(name, position);
    }


}
