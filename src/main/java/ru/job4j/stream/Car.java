package ru.job4j.stream;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Builder.class.getSimpleName() + "[", "]")
                .add("brand='" + brand + "'")
                .add("model='" + model + "'")
                .add("created=" + created)
                .add("volume=" + volume)
                .add("color='" + color + "'")
                .toString();
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);

        Car k5 = new Builder()
                .buildBrand("Kia")
                .buildModel("K5")
                .buildCreated(LocalDate.of(2019, 3, 3))
                .buildVolume(2.0)
                .buildColor("Black")
                .build();
        System.out.println(k5);
    }

}