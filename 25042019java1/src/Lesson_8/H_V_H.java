package Lesson_8;

import java.util.Random;

public class H_V_H {
    public static String[] result = {"Win X", "Win O", "Draw"};
    public static int counter = 0;

    private static final ResultWindow resultWindow = new ResultWindow(null);

    public static void humVsHum() {

        if (checkVictory(Map.DOT_X) == false && checkVictory(Map.DOT_O) == false && checkDraw() == true) {
            humanTurn();
            if (checkVictory(Map.DOT_X)) {
                resultWindow.ResultWindowViewOn(result[0]);
                return;
            }
            if (checkDraw() == false) return;
            if (checkVictory(Map.DOT_O)) {
                resultWindow.ResultWindowViewOn(result[1]);
                return;
            }
            if (checkDraw() == false) return;
        }
    }

    public static void humanTurn() {
        if (counter % 2 == 0)
            Map.field[Map.cellY][Map.cellX] = Map.DOT_X;
        else
            Map.field[Map.cellY][Map.cellX] = Map.DOT_O;
        counter++;
    }

    public static boolean isCellValid(int x, int y) {
        return Map.field[y][x] == Map.DOT_EMPTY;
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
                if (newArrCheck(arr, c)) {
                    counter = 0;
                    return true;
                }
                lineX++;
            }
            lineY++;
        }

        return false;
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

    public static boolean checkDraw() {
        for (int i = 0; i < Map.fieldSizeY; i++) {
            for (int j = 0; j < Map.fieldSizeX; j++) {
                if (Map.field[i][j] == Map.DOT_EMPTY) return true;
            }
        }
        resultWindow.ResultWindowViewOn(result[2]);
        counter = 0;
        return false;
    }

}
