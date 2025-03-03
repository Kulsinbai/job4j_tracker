package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int divide(int number) {
        if (x == 0) {
            System.out.println("Деление на ноль невозможно!");
        }
        return number / x;
    }

    public int sumAllOperation(int number) {
        int sumResult = sum(number);
        int multiplyResult = multiply(number);
        int minusResult = minus(number);
        int divideResult = divide(number);

        return sumResult + multiplyResult + minusResult + divideResult;
    }

    public static void main(String[] args) {
        int sumResult = Calculator.sum(10);
        System.out.println("Результат sum: " + sumResult);

        Calculator calculator = new Calculator();

        int multiplyResult = calculator.multiply(10);
        System.out.println("Результат multiply: " + multiplyResult);

        int minusResult = Calculator.minus(10);
        System.out.println("Результат minus: " + minusResult);

        int divideResult = calculator.divide(10);
        System.out.println("Результат divide: " + divideResult);

        int sumAllResult = calculator.sumAllOperation(10);
        System.out.println("Результат sumAllOperation: " + sumAllResult);
    }
}