package gb.lesson2;

import java.util.Arrays;
import java.util.Random;

public class lesson2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        zerosToOnes(arr1);
        System.out.println("\n");

        int[] arr2 = new int[8];
        massFill(arr2);
        System.out.println("\n");

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleLessSix(arr3);
        System.out.println("\n");

        int[][] arr4 = new int[9][9];
        fillDiagonals(arr4);
        System.out.println();

        int[] arr5 = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(200) - 100;
        }
        findMinMax(arr5);

        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 1, 1}));
        System.out.println();

        int[] arr7 = {1, 2, 3, 4, 5};
        int[] arr8 = {1, 2, 3, 4, 5};
        moveArray(arr7, 4);
        moveArray(arr8, -2);


    }

    public static void zerosToOnes(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void massFill(int[] a) {
        for (int i = 0; i < 8; i++) {
            a[i] = i * 3;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void doubleLessSix(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void fillDiagonals(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == j || i + j == a.length - 1) {
                    a[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMinMax(int[] a) {
        int max = a[0], min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            } else if (min > a[i]) {
                min = a[i];
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("Max = " + max + "\nMin = " + min + "\n");
    }

    public static boolean checkBalance(int[] a) {
        int leftSum, rightSum;
        for (int i = 0; i < a.length - 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = i; j >= 0; j--) {
                leftSum += a[j];
            }
            for (int j = i + 1; j < a.length; j++) {
                rightSum += a[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    public static void moveArray(int[] a, int n) {
        n %= a.length;
        int prev;
        int prevPrev;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                prev = a[a.length - 1];
                prevPrev = a[a.length - 2];
                for (int j = a.length - 2; j > 0; j--) {
                    a[j] = prev;
                    prev = prevPrev;
                    prevPrev = a[j - 1];
                }
                a[0] = prev;
                a[a.length - 1] = prevPrev;
            }
        } else {
            for (int i = 0; i > n; i--) {
                prev = a[0];
                prevPrev = a[1];
                for (int j = 1; j < a.length - 1; j++) {
                    a[j] = prev;
                    prev = prevPrev;
                    prevPrev = a[j + 1];
                }
                a[a.length - 1] = prev;
                a[0] = prevPrev;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

