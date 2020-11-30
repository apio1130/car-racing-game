package com.practice.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(Car... cars) {
        this.cars = new ArrayList<>(Arrays.asList(cars));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> findWinner() {
        int winnerPosition = findMaxPosition();
        return cars.stream().filter(c -> c.getPosition() == winnerPosition).collect(Collectors.toList());
    }
}
