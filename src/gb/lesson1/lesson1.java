package gb.lesson1;

public class lesson1 {
    public static void main(String[] args) {
        int a = 2147483647;
        byte b = 127;
        short sh = 32767;
        long l = 9223372036854775807L;

        float f = 123.456f;
        double d = 456.789;

        char c1 = 'c';
        char c2 = '\u0000';

        boolean bool = true;

        String str = "abcd";

        System.out.println(mathMethod(1, 2, 3, 4));
        System.out.println();
        System.out.println(isInRange(6, 12));
        System.out.println(isInRange(1, 3));
        System.out.println();
        isPositive(3);
        isPositive(-5);
        System.out.println();
        System.out.println(isNegative(6));
        System.out.println(isNegative(-6));
        System.out.println();
        helloName("buntlit");
        System.out.println();
        isLeapYear(1900);
        isLeapYear(2000);
        isLeapYear(2001);
        isLeapYear(2020);
    }

    public static double mathMethod(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean isInRange(int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Number " + a + " is positive");
        } else {
            System.out.println("Number " + a + " is negative");
        }
    }

    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void helloName(String st) {
        System.out.println("Hello, " + st + "!");
    }

    public static void isLeapYear(int a) {
        if (a % 400 == 0) {
            System.out.println(a + " is leap year");
        } else if (a % 100 == 0) {
            System.out.println(a + " is not leap year");
        } else if (a % 4 == 0) {
            System.out.println(a + " is leap year");
        } else {
            System.out.println(a + " is not leap year");
        }
    }
}
