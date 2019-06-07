package Lesson_8;

import java.util.Random;

public class H_V_A {

    public static String[] result = {"Victory", "Lose", "Draw"};

    private static final ResultWindow resultWindow = new ResultWindow(null);

    public static Random rand = new Random();

    public static void humVsAi() {

        if (checkVictory(Map.DOT_X) == false && checkVictory(Map.DOT_O) == false && checkDraw() == true) {
            humanTurn();
            if (checkVictory(Map.DOT_X)) {
                resultWindow.ResultWindowViewOn(result[0]);
                return;
            }
            if (checkDraw() == false) return;
            iiTurn();
            if (checkVictory(Map.DOT_O)) {
                resultWindow.ResultWindowViewOn(result[1]);
                return;
            }
            if (checkDraw() == false) return;
        }
    }

    public static void humanTurn() {
        Map.field[Map.cellY][Map.cellX] = Map.DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        return Map.field[y][x] == Map.DOT_EMPTY;
    }

    public static char[][] iiTurn() {
        int a, b, x, y, lineX, lineY = Map.winLength;
        char[][] arr = new char[Map.winLength][Map.winLength];
        for (int i = 0; i <= Map.fieldSizeY - Map.winLength; i++) {
            lineX = Map.winLength;
            for (int j = 0; j <= Map.fieldSizeX - Map.winLength; j++) {
                b = 0;
                for (int k = i; k < lineY; k++) {
                    a = 0;
                    for (int l = j; l < lineX; l++) {
                        arr[b][a] = Map.field[k][l];
                        a++;
                    }
                    b++;
                }
                for (int k = 0; k < Map.winLength; k++) {
                    for (int l = 0; l < Map.winLength; l++) {
                        if (arr[k][l] == Map.DOT_EMPTY) {
                            arr[k][l] = Map.DOT_O;
                            if (newArrCheck(arr, Map.DOT_O)) {
                                Map.field[i + k][j + l] = Map.DOT_O;
                                return Map.field;
                            }
                            arr[k][l] = Map.DOT_EMPTY;
                        }
                    }

                }
                lineX++;
            }
            lineY++;
        }
        lineY = Map.winLength;
        char[][] arr1 = new char[Map.winLength][Map.winLength];
        for (int i = 0; i <= Map.fieldSizeY - Map.winLength; i++) {
            lineX = Map.winLength;
            for (int j = 0; j <= Map.fieldSizeX - Map.winLength; j++) {
                b = 0;
                for (int k = i; k < lineY; k++) {
                    a = 0;
                    for (int l = j; l < lineX; l++) {
                        arr1[b][a] = Map.field[k][l];
                        a++;
                    }
                    b++;
                }
                for (int k = 0; k < Map.winLength; k++) {
                    for (int l = 0; l < Map.winLength; l++) {
                        if (arr1[k][l] == Map.DOT_EMPTY) {
                            arr1[k][l] = Map.DOT_X;
                            if (newArrCheck(arr1, Map.DOT_X)) {
                                Map.field[i + k][j + l] = Map.DOT_O;
                                return Map.field;
                            }
                            arr1[k][l] = Map.DOT_EMPTY;
                        }
                    }

                }
                lineX++;
            }
            lineY++;
        }
        do {
            x = rand.nextInt(Map.fieldSizeX);
            y = rand.nextInt(Map.fieldSizeY);
        } while (!isCellValid(x, y));
        Map.field[y][x] = Map.DOT_O;
        return Map.field;

    }

    public static boolean newArrCheck(char[][] arr, char c) {
        int a = 0;
        for (int i = 0; i < Map.winLength; i++) {
            for (int j = 0; j < Map.winLength; j++) {
                if (arr[i][j] == c) a++;
            }
            if (a == Map.winLength) return true;
            a = 0;
        }
        for (int i = 0; i < Map.winLength; i++) {
            for (int j = 0; j < Map.winLength; j++) {
                if (arr[j][i] == c) a++;
            }
            if (a == Map.winLength) return true;
            a = 0;
        }
        a = 0;
        for (int i = 0; i < Map.winLength; i++) {
            for (int j = 0; j < Map.winLength; j++) {
                if (i == j) {
                    if (arr[i][j] == c) a++;
                }
            }
            if (a == Map.winLength) return true;
        }
        a = 0;
        for (int i = 0; i < Map.winLength; i++) {
            for (int j = 0; j < Map.winLength; j++) {
                if (i + j == Map.winLength - 1) {
                    if (arr[i][j] == c) a++;
                }
            }
            if (a == Map.winLength) return true;
        }

        return false;
    }

    public static boolean checkVictory(char c) {
        int a, b, lineX, lineY = Map.winLength;
        char[][] arr = new char[Map.winLength][Map.winLength];
        for (int i = 0; i <= Map.fieldSizeY - Map.winLength; i++) {
            lineX = Map.winLength;
            for (int j = 0; j <= Map.fieldSizeX - Map.winLength; j++) {
                b = 0;
                for (int k = i; k < lineY; k++) {
                    a = 0;
                    for (int l = j; l < lineX; l++) {
                        arr[b][a] = Map.field[k][l];
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
        for (int i = 0; i < Map.fieldSizeY; i++) {
            for (int j = 0; j < Map.fieldSizeX; j++) {
                if (Map.field[i][j] == Map.DOT_EMPTY) return true;
            }
        }
        resultWindow.ResultWindowViewOn(result[2]);
        return false;
    }

}
