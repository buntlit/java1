package Lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        guessTheNumber();

        guessTheWord(words);
    }

    public static void guessTheNumber() {
        int a, b, c;
        do {
            a = rand.nextInt(10);
            int n = 3;
            System.out.println("Угадайте число от 0 до 9. Есть 3 попытки");
            do {
                b = getNumber(0, 9);
                n--;
                if (a == b) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (n > 0) {
                    System.out.println("Ошибка. У Вас осталось " + n + " попыток");
                    if (a > b)
                        System.out.println("Загаданное число больше");
                    else
                        System.out.println("Загаданное число меньше");
                } else
                    System.out.println("Вы проиграли. загадывалось число " + a);
            } while (n > 0);
            System.out.println("\nДля повтора игры нажмите 1, для выхода нажмите 0");
            c = getNumber(0, 1);
        } while (c != 0);
    }

    public static int getNumber(int min, int max) {
        int x;
        do {
            System.out.println("\nВведите число от " + min + " до " + max);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }
    public static void guessTheWord (String[] word) {
        int a = rand.nextInt(word.length);
        System.out.println("Компьютер загадал одно из этих слов:");
        System.out.println(Arrays.toString(word));
        System.out.println("Попробуйте угадать, какое");
        String s;
        char[] ch = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', };
        do{
            System.out.println("Введите слово:");
            s = sc.next();
            if (s.equals(word[a])){
                System.out.println("Вы угадали слово!");
                break;
            }
            int minLen = Math.min(word[a].length(), s.length());
            for (int i = 0; i < minLen; i++) {
                if (word[a].charAt(i) == s.charAt(i))
                    ch[i] = s.charAt(i);
            }
            for (int i = 0; i <ch.length ; i++) {
                System.out.print(ch[i]);
            }
            System.out.println();
        } while (true);


    }
}