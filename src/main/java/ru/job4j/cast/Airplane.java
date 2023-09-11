package ru.job4j.cast;

public class Airplane implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху.");
    }
}
