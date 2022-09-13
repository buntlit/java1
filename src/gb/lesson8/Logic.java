package gb.lesson8;

import java.util.Random;


public class Logic {

    static char[][] map;
    static int size = 3;
    static int dotToWin = 3;

    private static final char DOT_EMPTY = '.';
    static final char DOT_X = 'X';
    static final char DOT_WIN_X = 'x';
    static final char DOT_O = 'O';
    static final char DOT_WIN_O = 'o';
    private static Random random = new Random();
    static boolean gameFinished;
    private static final int MODE_H_V_A = 0;
    private static final int MODE_H_V_H = 1;
    private static int counterSteps = 0;
    private static ResultWindow resultWindow = new ResultWindow();

    private static void goHvA() {

        gameFinished = true;

        if (checkWin(DOT_X)) {
            checkWin(DOT_X, DOT_WIN_X);
            resultWindow.setTextResult("YOU WIN!!11!");
            return;
        } else if (!isEmpty()) {
            resultWindow.setTextResult("DRAW");
            return;
        }

        robotTurn();

        if (checkWin(DOT_O)) {
            checkWin(DOT_O, DOT_WIN_O);
            resultWindow.setTextResult("YOU LOSE!!=(");
            return;
        } else if (!isEmpty()) {
            resultWindow.setTextResult("DRAW");
            return;
        }
        gameFinished = false;

    }

    private static void goHvH() {

        gameFinished = true;

        if (checkWin(DOT_X)) {
            checkWin(DOT_X, DOT_WIN_X);
            resultWindow.setTextResult("X WIN!!11!");
            return;
        }
        if (!isEmpty()) {
            resultWindow.setTextResult("DRAW");
            return;
        }
        if (checkWin(DOT_O)) {
            checkWin(DOT_O, DOT_WIN_O);
            resultWindow.setTextResult("O WIN!!11!");
            return;
        }
        gameFinished = false;

    }

    public static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void setHumanCoordinates(int x, int y, int gameMode) {
        if (isValid(y, x)) {
            if (gameMode == MODE_H_V_A) {
                map[y][x] = DOT_X;
                goHvA();
            } else if (gameMode == MODE_H_V_H) {
                if (counterSteps % 2 == 0) {
                    map[y][x] = DOT_X;
                } else {
                    map[y][x] = DOT_O;
                }
                counterSteps++;
                goHvH();
            }
        }
    }

    public static boolean isValid(int y, int x) {
        return (x < 0 || x >= size) || (y < 0 || y >= size) || map[y][x] == DOT_EMPTY;
    }

    public static void robotTurn() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isValid(y, x));
        map[y][x] = DOT_O;

    }

    public static boolean checkWin(char dot) {
        int horizontalLine, verticalLine, diagonalMain, diagonalSub;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                horizontalLine = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[i][j + k] == dot) {
                        horizontalLine++;
                    }
                    if (horizontalLine == dotToWin) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                verticalLine = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[j + k][i] == dot) {
                        verticalLine++;
                    }
                    if (verticalLine == dotToWin) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < size - (dotToWin - 1); i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                diagonalMain = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[i + k][j + k] == dot) {
                        diagonalMain++;
                    }
                    if (diagonalMain == dotToWin) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < size - (dotToWin - 1); i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                diagonalSub = 0;
                for (int k = dotToWin - 1; k >= 0; k--) {
                    if (map[i + (dotToWin - (k + 1))][j + k] == dot) {
                        diagonalSub++;
                    }
                    if (diagonalSub == dotToWin) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void checkWin(char dot, char dotNew) {
        int horizontalLine, verticalLine, diagonalMain, diagonalSub;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                horizontalLine = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[i][j + k] == dot) {
                        horizontalLine++;
                    }
                    if (horizontalLine == dotToWin) {
                        for (int l = 0; l < dotToWin; l++) {
                            map[i][j + l] =  dotNew;
                        }
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                verticalLine = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[j + k][i] == dot) {
                        verticalLine++;
                    }
                    if (verticalLine == dotToWin) {
                        for (int l = 0; l < dotToWin; l++) {
                            map[j + l][i] = dotNew;
                        }
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < size - (dotToWin - 1); i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                diagonalMain = 0;
                for (int k = 0; k < dotToWin; k++) {
                    if (map[i + k][j + k] == dot) {
                        diagonalMain++;
                    }
                    if (diagonalMain == dotToWin) {
                        for (int l = 0; l < dotToWin; l++) {
                            map[i + l][j + l] = dotNew;
                        }
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < size - (dotToWin - 1); i++) {
            for (int j = 0; j < size - (dotToWin - 1); j++) {
                diagonalSub = 0;
                for (int k = dotToWin - 1; k >= 0; k--) {
                    if (map[i + (dotToWin - (k + 1))][j + k] == dot) {
                        diagonalSub++;
                    }
                    if (diagonalSub == dotToWin) {
                        for (int l = 0; l < dotToWin; l++) {
                            map[i + (dotToWin - (l + 1))][j + l] = dotNew;
                        }
                        return;
                    }
                }
            }
        }
    }

    public static boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

}
