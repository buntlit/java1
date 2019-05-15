package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static char[][] map;
    public static final int SIZE = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        do {
            humanTurn();
            printMap();
            if (checkVictory(DOT_X) ==true){
                System.out.println("Вы выиграли");
                break;
            }
            if (checkDraw() ==false) break;
            iiTurn();
            printMap();
            if (checkVictory(DOT_O)==true){
                System.out.println("Вы проиграли");
                break;
            }
            if (checkDraw()==false) break;
        } while (true);
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты X и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void iiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int x, int y) {
        return (x >= 0 && x < SIZE && y >= 0 && y < SIZE) && map[y][x] == DOT_EMPTY;
    }

    public static boolean checkVictory(char c) {
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) return true;
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) return true;
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) return true;

        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        return false;
    }
    public static boolean checkDraw(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==DOT_EMPTY) return true;
            }
        }
        System.out.println("Ничья");
        return false;
    }
}