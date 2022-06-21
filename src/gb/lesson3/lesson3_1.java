package gb.lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3_1 {
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        int exit;
        do {
            int inputNum, counter, num = random.nextInt(10);
            System.out.println("Robot pick a number 0 to 9. Try to guess it. You have 3 tries\n");
            for (counter = 0; counter < 3; counter++) {
                inputNum = checkCorrectInput(0, 9, "Input number 0 to 9:");
                if (inputNum > num) {
                    lessOrHigher("higher", counter);
                } else if (inputNum < num) {
                    lessOrHigher("less", counter);
                } else {
                    System.out.println("YOU WIN!!11!");
                    break;
                }
            }
            if (counter == 3) {
                System.out.println("YOU LOSE=( It was " + num);
            }
            System.out.println("\nAgain? 1 - Yes, 0 - No");
            exit = checkCorrectInput(0, 1, "Input number 0 or 1");

        } while (exit != 0);
        System.out.println("Have a nice day!");
    }

    public static int checkCorrectInput(int left, int right, String phrase) {
        int inNum;
        do {
            System.out.println(phrase);
            inNum = scanner.nextInt();
        } while (left > inNum || inNum > right);
        return inNum;
    }

    public static void lessOrHigher(String lOH, int counter) {
        System.out.println("Your number is " + lOH + " than Robot. You have " + (2 - counter) + " tries");
    }
}
