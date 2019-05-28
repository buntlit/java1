package Lesson_2;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        invertArray();

        fillArray();

        changeArray();

        crossArray();

        findMinMax();

        int[] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr1)+"\n");

        int[] arr2 = {5, 6, 7, 8, 9, 10, 11, 12, 13};
        checkArr(10, arr2);

    }

    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] - 1) * (-1);
        }
        System.out.println(Arrays.toString(arr) + "\n");
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr) + "\n");
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr) + "\n");
    }

    public static void crossArray() {
        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i == j) || (i + j == arr.length - 1))
                    arr[i][j] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMinMax() {
        int[] arr = {1, 5, 3, 2, 11, -2, 5, 2, 4, 8, 9, 1};
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            else if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("\n" + Arrays.toString(arr));
        System.out.println("Минимальное значение равно " + min + "\nМаксимальное значение равно " + max + "\n");
    }

    public static boolean checkBalance(int[] arr) {
        int summ = 0;
        boolean a = false;
        for (int i = 0; i < arr.length; i++) {
            summ += arr[i];
        }
        if (summ % 2 == 0) {
            int checkSumm = 0, i = 0;
            while (checkSumm <= summ / 2) {
                checkSumm += arr[i];
                i++;
                if (checkSumm == summ / 2) {
                    a = true;
                    break;
                } else if (checkSumm >= summ / 2)
                    a = false;
            }
        } else
            a = false;
        return a;
    }

    public static void checkArr(int n, int[] arr) {
        System.out.println(Arrays.toString(arr));
        n = n % arr.length;
        int a, b;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                a = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    b = arr[(j + 1) % arr.length];
                    arr[(j + 1) % arr.length] = a;
                    a = b;
                }
            }
        } else {
            for (int i = 0; i > n; i--) {
                a = arr[arr.length - 1];
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (j - 1 >= 0) {
                        b = arr[(j - 1) % arr.length];
                        arr[(j - 1) % arr.length] = a;
                    } else {
                        b = arr[(arr.length - j - 1) % arr.length];
                        arr[(arr.length - j - 1) % arr.length] = a;
                    }
                    a = b;
                }
            }
        }
        System.out.print(Arrays.toString(arr));

    }
}


