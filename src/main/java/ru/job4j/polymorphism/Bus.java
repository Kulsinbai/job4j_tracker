package ru.job4j.polymorphism;

public class Bus implements Transport {
    public void move() {
        System.out.println("Автобус едет по маршруту");
    }

    public void passengers(int count) {
        System.out.println("Число пассажиров: " + count);
    }

    public int refuel(int fuel) {
        int pricePerLiter = 50;
        return fuel * pricePerLiter;
    }
}
