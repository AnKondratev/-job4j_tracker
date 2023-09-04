package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int sum) {
        return sum;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("x + y = " + Calculator.sum(10));
        System.out.println("x * a = " + calculator.multiply(5));
        System.out.println("z - x = " + Calculator.minus(10));
        System.out.println("b / x = " + calculator.divide(25));
        System.out.println("Сумма всех вычислений ровна: "
                + calculator.sumAllOperation(Calculator.sum(10)
                + calculator.multiply(5)
                + Calculator.minus(10)
                + calculator.divide(25)));
    }
}