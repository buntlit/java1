public class MainClass {
    public static void main(String[] args) {                                    //1 задание

        int integer = 1526984;                                                  //2 задание
        byte byt = 125;
        short shor = 12568;
        long lon = 1269546845l;
        char cha = 'S';
        boolean bool = true;
        double doub = 3.14;
        float flo = 3.14f;
        String string = "Hello";

        System.out.println(mathResult(5, 7, 2, 4));                 //3 задание

        System.out.println(summCheck(6, 8));                               //4 задание

        isPositive(10);                                                      //5 задание

        System.out.println(isNegative(-15));                                 //6 задание

        helloName("Igor");                                                      //7 задание

        leapYear(1364);                                                         //8 задание
    }

    public static double mathResult(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean summCheck(int e, int f) {
        return e + f >= 10 && e + f <= 20;
    }

    public static void isPositive(int g) {
        if (g >= 0)
            System.out.println("Positive");
        else
            System.out.println("Negative");
    }

    public static boolean isNegative(int h) {
        return h < 0;
    }

    public static void helloName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void leapYear(int year){
        int check = year % 400;
        if (check ==0)
            System.out.println(year + " is leap year");
        else {
            check %=100;
            if (check == 0)
                System.out.println(year +" is not leap year");
            else {
                check %=4;
                if (check == 0)
                    System.out.println(year + " is leap year");
                else
                    System.out.println(year +" is not leap year");
            }
        }
    }

}

