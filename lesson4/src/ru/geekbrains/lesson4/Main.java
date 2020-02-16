package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        initMap();
        printMap();
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin0(DOT_X)) {
                System.out.println("Поздравляю! Ты победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin0(DOT_O)) {
                System.out.println("Очень жаль! Ты проиграл!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена.");

    }

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

    }

    public static boolean checkRow(char symb, int row) {    //Проверка ряда
        for(int i = 0; i < SIZE; i++) {  //i номер столбца
            if(map[row][i] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(char symb, int col) {  //Проверка столбца
        for(int i = 0; i < SIZE; i++) {
            if(map[i][col] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiag1(char symb) {  //Проверка диагонали 1
        for(int i = 0; i < SIZE; i++) {
            if (map[i][i] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiag2(char symb) {  //Проверка диагонали 2
        for(int i = 0; i < SIZE; i++) {
            if (map[SIZE - 1 - i][i] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWin0(char symb) {    //Проверка победы

        for (int i = 0; i < SIZE; i++) {
            if (checkRow(symb, i)) {
                return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (checkCol(symb, i)) {
                return true;
            }
        }

        if(checkDiag1(symb)) return true;
        if(checkDiag2(symb)) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void humanTurn() {    //Ход игрока
        int x, y;
        System.out.println("Введите координаты в формате X Y");
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {  //проверяет можно ли сделать такой ход

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {    //Заполнение поля пустыми клетками
        map = new char [SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {  //Вывод поля в консоль
        for(int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
