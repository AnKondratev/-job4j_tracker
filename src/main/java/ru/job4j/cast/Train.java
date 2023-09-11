package ru.job4j.cast;

public class Train implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по рельсам.");
    }
}
