package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Пассажиров в автобусе: " + amount);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 51;
    }
}
