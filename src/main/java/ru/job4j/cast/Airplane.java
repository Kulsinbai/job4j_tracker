package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void capacity() {
        System.out.println(getClass().getSimpleName() + " средняя вместимость: 100 человек.");
    }
}