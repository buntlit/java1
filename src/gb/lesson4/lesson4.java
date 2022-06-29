package gb.lesson4;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOT_TO_WIN = 4;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        do {
            humansTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("YOU WIN!!11!");
                break;
            } else if (!isEmpty()) {
                System.out.println("DRAW");
                break;
            }

            robotTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("YOU LOSE!!=(1");
                break;
            } else if (!isEmpty()) {
                System.out.println("DRAW");
                break;
            }

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
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 1; j <= SIZE; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                for (int j = 0; j <= SIZE; j++) {
                    if (j == 0) {
                        System.out.print(i + " ");
                    } else {
                        System.out.print(map[i - 1][j - 1] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void humansTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinate X and Y:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isValid(int y, int x) {
        return (x < 0 || x >= SIZE) || (y < 0 || y >= SIZE) || map[y][x] == DOT_EMPTY;
    }

    public static void robotTurn() {
        int countO = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        countO++;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        int countX = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        countX++;
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isValid(y, x));
        map[y][x] = DOT_O;

    }

    /*по изначальному условию*/

//    public static boolean checkWin(char a) {
//        int h, v, diagMain = 0, diagSub = 0;
//        for (int i = 0; i < SIZE; i++) {
//            h = 0;
//            v = 0;
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == a) {
//                    h++;
//                }
//            }
//            for (int j = 0; j < SIZE; j++) {
//                if (map[j][i] == a) {
//                    v++;
//                }
//            }
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == a) {
//                    if (i == j) {
//                        diagMain++;
//                    }
//                    if (i + j == SIZE - 1) {
//                        diagSub++;
//                    }
//                }
//            }
//            if (h == DOT_TO_WIN || v == DOT_TO_WIN || diagMain == DOT_TO_WIN || diagSub == DOT_TO_WIN) {
//                return true;
//            }
//        }
//        return false;
//    }


    /*если линия для победы меньше размера поля*/
    public static boolean checkWin(char a) {
        int h, v, diagMain, diagSub;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - (DOT_TO_WIN - 1); j++) {
                h = 0;
                for (int k = 0; k < DOT_TO_WIN; k++) {
                    if (map[i][j + k] == a) {
                        h++;
                    }
                    if (h == DOT_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - (DOT_TO_WIN - 1); j++) {
                v = 0;
                for (int k = 0; k < DOT_TO_WIN; k++) {
                    if (map[j + k][i] == a) {
                        v++;
                    }
                    if (v == DOT_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE - (DOT_TO_WIN - 1); i++) {
            for (int j = 0; j < SIZE - (DOT_TO_WIN - 1); j++) {
                diagMain = 0;
                for (int k = 0; k < DOT_TO_WIN; k++) {
                    if (map[i + k][j + k] == a) {
                        diagMain++;
                    }
                    if (diagMain == DOT_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE - (DOT_TO_WIN - 1); i++) {
            for (int j = 0; j < SIZE - (DOT_TO_WIN - 1); j++) {
                diagSub = 0;
                for (int k = DOT_TO_WIN - 1; k >= 0; k--) {
                    if (map[i + (DOT_TO_WIN - (k + 1))][j + k] == a) {
                        diagSub++;
                    }
                    if (diagSub == DOT_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

}
