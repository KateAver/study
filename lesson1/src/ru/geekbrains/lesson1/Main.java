package ru.geekbrains.lesson1;

public class Main {

    public static void main(String[] args) {
        // Целочисленные типы данных
        byte b = 100;
        short sh = 1000;
        int i = 1_000_000_000;
        long l = 1_000_000_000_000_000_000L;

        // С плавающей запятой
        float f = 1234.5678f;
        double d = 1234.5678;

        // Символьный
        char c = '1';

        // Логический
        boolean bo = true;

        // Строковый тип данных
        String s = "";
    }

    public static int mathExpression(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }


    public static boolean sumInRange(int a, int b) {
        if(a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printSign(int a) {
        if(a >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }


    public static boolean printNumber(int b) {
        if(b <= 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void printName(String name) {
        System.out.println("Hello, " + name);
    }


    public static void isLeapYear(int year) {
        if(year % 400 == 0) {
            System.out.println("leap");
            return;
        }
        if(year % 100 == 0) {
            System.out.println("not leap");
            return;
        }
        if(year % 4 == 0) {
            System.out.println("leap");
        } else {
            System.out.println("not leap");
        }
    }
}
