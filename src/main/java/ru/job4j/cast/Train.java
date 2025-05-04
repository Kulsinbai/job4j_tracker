package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }
    @Override
    public void capacity() {
        System.out.println(getClass().getSimpleName() + " средняя вместимость: 500 человек.");
    }
}
