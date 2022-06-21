package gb.lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3_2 {
    static Random random;
    static Scanner scanner;

    public static void main(String[] args) {
        random = new Random();
        scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] peloChedus = new char[15];
        for (int i = 0; i < 15; i++) {
            peloChedus[i] = '#';
        }
        String inputString;
        String keyWord = words[random.nextInt(words.length)];
        System.out.println("Robot pick up one word from this list:");
        for (String word : words) {
            System.out.print(word + "  ");
        }
        System.out.println("\nGuess it!\n");
        do {
            System.out.println("Enter your variant:");
            inputString = scanner.next();
            if (!keyWord.equals(inputString)) {
                System.out.println("Wrong. You guess:");
                for (int i = 0; i < minLength(peloChedus.length, inputString.length(), keyWord.length()); i++) {
                    if (keyWord.charAt(i) == inputString.charAt(i)) {
                        peloChedus[i] = keyWord.charAt(i);
                    }
                }
                for (char pelo : peloChedus) {
                    System.out.print(pelo);
                }
                System.out.println("\n");
            } else {
                System.out.println("Correct!!!");
            }

        } while (!keyWord.equals(inputString));
    }

    public static int minLength(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }
}
