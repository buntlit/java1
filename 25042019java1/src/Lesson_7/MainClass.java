package Lesson_7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cat = new Cat[10];
        cat[0] = new Cat("Мурзик");
        cat[1] = new Cat("Оливер");
        cat[2] = new Cat("Ася");
        cat[3] = new Cat("Барсик");
        cat[4] = new Cat("Маркиз");
        cat[5] = new Cat("Мурка");
        cat[6] = new Cat("Кеша");
        cat[7] = new Cat("Рыжик");
        cat[8] = new Cat("Ириска");
        cat[9] = new Cat("Бася");

        Plate plate = new Plate(100);
        System.out.println(plate);
        for (Cat c : cat) {
            System.out.println(c);
        }
        for (Cat c : cat) {
            c.eat(plate);
        }
        for (Cat c : cat) {
            c.satietyCheck();
        }
    }
}
