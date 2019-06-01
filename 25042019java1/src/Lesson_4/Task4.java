package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int LINE_TO_WIN = 4;
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
            if (checkVictory(DOT_X) == true) {
                System.out.println("Вы выиграли");
                break;
            }
            if (checkDraw() == false) break;
            iiTurn();
            printMap();
            if (checkVictory(DOT_O) == true) {
                System.out.println("Вы проиграли");
                break;
            }
            if (checkDraw() == false) break;
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

    public static char[][] iiTurn() {
        int a, b, x, y, lineX, lineY = LINE_TO_WIN;
        char[][] arr = new char[LINE_TO_WIN][LINE_TO_WIN];
        for (int i = 0; i <= SIZE - LINE_TO_WIN; i++) {
            lineX = LINE_TO_WIN;
            for (int j = 0; j <= SIZE - LINE_TO_WIN; j++) {
                b = 0;
                for (int k = i; k < lineY; k++) {
                    a = 0;
                    for (int l = j; l < lineX; l++) {
                        arr[b][a] = map[k][l];
                        a++;
                    }
                    b++;
                }
                for (int k = 0; k < LINE_TO_WIN; k++) {
                    for (int l = 0; l < LINE_TO_WIN; l++) {
                        if (arr[k][l] == DOT_EMPTY) {
                            arr[k][l] = DOT_O;
                            if (newArrCheck(arr, DOT_O)) {
                                map[i + k][j + l] = DOT_O;
                                return map;
                            }
                            arr[k][l] = DOT_X;
                            if (newArrCheck(arr, DOT_X)) {
                                map[i + k][j + l] = DOT_O;
                                return map;
                            }
                            arr[k][l] = DOT_EMPTY;
                        }
                    }

                }
                lineX++;
            }
            lineY++;
        }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        return map;

    }

    public static boolean isCellValid(int x, int y) {
        return (x >= 0 && x < SIZE && y >= 0 && y < SIZE) && map[y][x] == DOT_EMPTY;
    }

    public static boolean checkVictory(char c) {
        int a, b, lineX, lineY = LINE_TO_WIN;
        char[][] arr = new char[LINE_TO_WIN][LINE_TO_WIN];
        for (int i = 0; i <= SIZE - LINE_TO_WIN; i++) {
            lineX = LINE_TO_WIN;
            for (int j = 0; j <= SIZE - LINE_TO_WIN; j++) {
                b = 0;
                for (int k = i; k < lineY; k++) {
                    a = 0;
                    for (int l = j; l < lineX; l++) {
                        arr[b][a] = map[k][l];
                        a++;
                    }
                    b++;
                }
                if (newArrCheck(arr, c)) return true;
                lineX++;
            }
            lineY++;
        }

        return false;
    }

    public static boolean checkDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return true;
            }
        }
        System.out.println("Ничья");
        return false;
    }

    public static boolean newArrCheck(char[][] arr, char c) {
        int a = 0;
        for (int i = 0; i < LINE_TO_WIN; i++) {
            for (int j = 0; j < LINE_TO_WIN; j++) {
                if (arr[i][j] == c) a++;
            }
            if (a == LINE_TO_WIN) return true;
            a = 0;
        }
        for (int i = 0; i < LINE_TO_WIN; i++) {
            for (int j = 0; j < LINE_TO_WIN; j++) {
                if (arr[j][i] == c) a++;
            }
            if (a == LINE_TO_WIN) return true;
            a = 0;
        }
        a = 0;
        for (int i = 0; i < LINE_TO_WIN; i++) {
            for (int j = 0; j < LINE_TO_WIN; j++) {
                if (i == j) {
                    if (arr[i][j] == c) a++;
                }
            }
            if (a == LINE_TO_WIN) return true;
        }
        a = 0;
        for (int i = 0; i < LINE_TO_WIN; i++) {
            for (int j = 0; j < LINE_TO_WIN; j++) {
                if (i + j == LINE_TO_WIN - 1) {
                    if (arr[i][j] == c) a++;
                }
            }
            if (a == LINE_TO_WIN) return true;
        }

        return false;
    }
}