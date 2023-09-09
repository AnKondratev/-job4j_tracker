package ru.job4j.poly;

public interface Transport {

    void run();

    void passengers(int amount);

    int refuel(int fuel);

}
