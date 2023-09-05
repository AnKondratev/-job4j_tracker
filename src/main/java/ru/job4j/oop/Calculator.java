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
        return sum(sum) + multiply(sum) + minus(sum) + divide(sum);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("x + y = " + Calculator.sum(5));
        System.out.println("x * a = " + calculator.multiply(5));
        System.out.println("z - x = " + Calculator.minus(5));
        System.out.println("b / x = " + calculator.divide(5));
        System.out.println("Сумма всех вычислений ровна: " + calculator.sumAllOperation(5));
    }
}