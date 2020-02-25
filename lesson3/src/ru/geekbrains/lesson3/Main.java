package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(10);
        int count = 3;
        Scanner sc = new Scanner(System.in);

        while(true) {
            int answer = sc.nextInt();
            if (answer < number) {
                System.out.println("Ваше число меньше");
                count = count - 1;
            } else if (answer > number) {
                System.out.println("Ваше число больше");
                count = count - 1;
            } else {
                System.out.println("Вы угадали! Хотите сыграть еще раз?");
                int retry = sc.nextInt();
                if (retry == 0) {
                    break;
                } else {
                    number = rand.nextInt(10);
                    count = 3;
                }
            }
            if (count == 0) {
                System.out.println("Вы проиграли. Ваши попытки закончились. Хотите сыграть еще раз?");
                int retry = sc.nextInt();
                if (retry == 0) {
                    break;
                } else {
                    number = rand.nextInt(10);
                    count = 3;
                }
            }
        }
    }
}